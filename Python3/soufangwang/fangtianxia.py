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
__url = 'https://fangjia.fang.com/fangjia/suggestion/transfer/' + __city


def __splitAreaCode(url):
    code = url.replace('https://fangjia.fang.com/process/sh/','').replace('.htm', '')
    return code

# return areaName


def getAreaCode(areaName):
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


def getAreaPrice(areaCode):
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


def __getChenJiaoFromHtml(html, count, result, split):
    d = pq(html)
    if(count == 0):
        th = d('div.dealSent table tr th').items()
        for i in th:
            result += str(i.text().replace('\n', '&')) + ','
        result = result[:-1]
        result += '\n'
    td = d('div.dealSent table tr td').items()
    for j in td:
        split = split + 1
        result += str(j.text().replace('\n', ' ')) + ','
        if(split > 0 and split % 6 == 0):
            result += '\n'
    return result

def getChengJiaoByName(name):
    url = "https://huashayicun.fang.com/chengjiao/"
    geckodriverPath = r'./drivers//geckodriver.exe'

    try:
        driver = webdriver.Firefox(executable_path=geckodriverPath)
        driver.get(url)
        count = 0
        result = ''
        split = 0
        result = __getChenJiaoFromHtml(driver.page_source, count, result, split)
        element = driver.find_element_by_id("ctl00_hlk_next")
        while(element):
            element.click()
            count = count + 1
            result = __getChenJiaoFromHtml(driver.page_source, count, result, split)
            element = driver.find_element_by_id("ctl00_hlk_next")
    except NoSuchElementException:
        print('There is no  more data! {}'.format(driver.current_url))
    finally:
        driver.close()
        append('./data/data.txt', result)


def getPriceByAreaName(areaName):
    areaCode = getAreaCode(areaName)
    price = getAreaPrice(areaCode)
    result = '"' + areaName + '" : ' + price
    return result
