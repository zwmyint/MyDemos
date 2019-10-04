import requests
import json
from datetime import datetime
from requests.exceptions import HTTPError

__city = 'sh'
__years = 3
__url = 'https://fangjia.fang.com/fangjia/suggestion/transfer/' + __city


def __splitAreaCode(url):
    code = url.replace('https://fangjia.fang.com/process/sh/','').replace('.htm', '')
    return code

#return areaName
def getAreaCode(areaName):
    try:
        response = requests.get(__url, params={
            'projname': areaName, 'strnewcode':'', 'strcity':'', 'boolnewsearch':'True','_csrf':'4b67zSz1-y-qYKvkBb19Wa26KtX7eiwIDPSY'
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

#return 2019-10
def covertTimestamp2Str(timestamp):
    date_time = datetime.fromtimestamp(timestamp)
    return date_time.strftime("%Y-%m")


def getPriceByAreaName(areaName) : 
    areaCode = getAreaCode(areaName)
    price = getAreaPrice(areaCode)
    result = '"' + areaName + '" : ' + price
    return result



