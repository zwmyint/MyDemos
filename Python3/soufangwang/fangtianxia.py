import requests
import json
from pyquery import PyQuery as pq
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from datetime import datetime
from requests.exceptions import HTTPError
from fileutil import append

__city = 'sh'
__years = 3
__geckodriverPath = r'./drivers//geckodriver.exe'
__url = 'https://fangjia.fang.com/fangjia/suggestion/transfer/' + __city


def __splitAreaCode(url):
    code = url.replace('https://fangjia.fang.com/process/sh/','').replace('.htm', '')
    return code

# return areaName
def __getAreaCode(areaName):
    try:
        response = requests.get(__url, params={
            'projname': areaName, 'strnewcode': '', 'strcity': '', 'boolnewsearch': 'True', '_csrf': '4b67zSz1-y-qYKvkBb19Wa26KtX7eiwIDPSY'
        })
        code = response.status_code
        if(code == 200):
            return __splitAreaCode(response.url)
        else:
            return ''
    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Success!')

# return price array


def __getAreaPrice(areaCode):
    try:
        response = requests.get('https://fangjia.fang.com/fangjia/common/ajaxdetailtrenddata/' + __city, params={
            'dataType': 'proj', 'projcode': areaCode, 'year': __years
        })
        code = response.status_code
        if(code == 200):
            return response.text
        else:
            return ''
    except HTTPError as http_err:
        print(f'HTTP error occurred: {http_err}')
    except Exception as err:
        print(f'Other error occurred: {err}')
    else:
        print('Success!')


def __getChenJiaoFromHtml(html, count, result):
    d = pq(html)
    if(count == 0):
        th = d('div.dealSent table tr th').items()
        result['label'] = []
        result['items'] = []
        for i in th:
            result['label'].append(str(i.text()))
    td = d('div.dealSent table tr td').items()
    split = 0
    for j in td:
        if(split == 0) :
            item = []
        item.append(str(j.text().replace('\n', ' ')))
        if (split > 0 and split % 5 == 0):
            result['items'].append(item)
            split = 0
        else:
            split += 1


def getChengJiaoByName(name):
    url = "https://huashayicun.fang.com/chengjiao/"
    #url = "https://yuanxierju.fang.com/chengjiao/"
    result = {}
    try:
        driver = webdriver.Firefox(executable_path=__geckodriverPath)
        driver.get(url)
        count = 0
        __getChenJiaoFromHtml(driver.page_source, count, result)
        element = driver.find_element_by_id("ctl00_hlk_next")
        while(element):
            element.click()
            count = count + 1
            __getChenJiaoFromHtml(driver.page_source, count, result)
            element = driver.find_element_by_id("ctl00_hlk_next")
    except NoSuchElementException:
        print('There is no  more data! {}, total: {}'.format(driver.current_url, len(result['items'])))
    finally:
        driver.close()
        append('./data/data.txt', json.dumps(result))


def getPriceByAreaName(areaName):
    areaCode = __getAreaCode(areaName)
    price = __getAreaPrice(areaCode)
    result = '"' + areaName + '" : ' + price
    return result
