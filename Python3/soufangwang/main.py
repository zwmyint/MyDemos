from selenium import webdriver
from fangtianxia import getAvgPrice
from fangtianxia import getChengjiao
from fileutil import read
from fileutil import write
import json
from datetimeutil import format


geckodriverPath = r'./drivers/geckodriver.exe'

def __createIndexHtml(jsonData, dataChengjiao):
    colors = ['#FF6384', '#36A2EB', '#9C27B0', '#673AB7', '#3F51B5', '#009688', '#4CAF50', '#AED581', '#EEFF41', '#FF8A65', '#FFEB3B']
    dataAvg = {}
    datasets = []
    labels = []
    count = 0
    for key in jsonData:
        dataset = {}
        data = []
        dataset['label'] = key
        dataset['data'] = data
        dataset['backgroundColor'] = colors[count]
        dataset['borderColor'] = colors[count]
        dataset['fill'] = False
        for value in jsonData[key]:
            dataTime = value[0]
            price = value[1]
            data.append(str(price))
            if count==0 :
                labels.append(str(format(dataTime)))
        count+=1
        datasets.append(dataset)
    dataAvg['datasets'] = datasets
    dataAvg['labels'] = labels
    htmlContent = read('./frontend/vm/index.vm')
    htmlContent = htmlContent.replace('${dataAvg}', json.dumps(dataAvg))
    htmlContent = htmlContent.replace('${dataChengjiao}', dataChengjiao)
    write('./frontend/index.html', htmlContent)

def getInfo():
    areas = ['华沙一村', '园西一居', '临丰小区', '青夏小区', '上浦小区']
    dataAvg = getAvgPrice(areas)
    areaNames = {
        'shangpuxiaoqu' : '上浦小区',
        'huashayicun' : '华沙一村',
        'yuanxierju' : '园西一居',
        'linfengxiaoqu' : '临丰小区',
        'qingxiaxiaoqu2' : '青夏小区'
        
    }
    chengJiaoResult = getChengjiao(areaNames)
    __createIndexHtml(dataAvg, chengJiaoResult)
    #driver = webdriver.Firefox(executable_path=geckodriverPath)
    #driver.get("file:///" + indexPath)

def main():
    getInfo()


if __name__ == '__main__':
    main()