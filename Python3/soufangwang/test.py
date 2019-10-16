from fangtianxia import getChengJiaoByName
from fileutil import read
import json
from datetimeutil import format


def indexHtml(jsonStr):
    content = read('./frontend/index.html')
    print(content)


def main():
    result = {}
    result['count'] = 0
    areaNames = ['yuanxierju', 'huashayicun']
    for name in areaNames:
        getChengJiaoByName(name, result)
    print(result)
    #indexHtml('')
    #print(format(1475251200000))
   

if __name__ == '__main__':
    main()