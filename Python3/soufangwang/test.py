from fangtianxia import getChengjiao
from fileutil import read
import json
import time
from datetimeutil import format


__retry = 3
def indexHtml(jsonStr):
    content = read('./frontend/index.html')
    print(content)

def fun():
    try:
        print('retry time {}'.format(__retry))
    except Exception:
        pass





def main():
    #indexHtml('')
    #print(format(1475251200000))
    #getChengjiao([])
    city = {
        "name": "你好！"
    }

    for key in city:
        print(city[key])
    
    time.sleep(5)
    fun()
   

if __name__ == '__main__':
    main()