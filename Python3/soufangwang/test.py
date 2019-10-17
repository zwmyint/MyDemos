from fangtianxia import getChengjiao
from fileutil import read
import json
from datetimeutil import format


def indexHtml(jsonStr):
    content = read('./frontend/index.html')
    print(content)





def main():
    #indexHtml('')
    #print(format(1475251200000))
    #getChengjiao([])
    city = {
        "name": "你好！"
    }

    for key in city:
        print(city[key])
   

if __name__ == '__main__':
    main()