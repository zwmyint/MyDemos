from selenium import webdriver
from fangtianxia import getPriceByAreaName
from fileutil import read
from fileutil import write
import json
from datetimeutil import format


def createIndexHtml(jsonData):
    colors = ['#FF6384', '#36A2EB', '#9C27B0', '#673AB7', '#3F51B5', '#009688', '#4CAF50', '#AED581', '#EEFF41', '#FF8A65', '#FFEB3B']
    dataAvg = {}
    datasets = []
    labels = []
    count = 0;
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
    write('./frontend/index.html', htmlContent)

def main():
    # Add the areas you love
    areas = ['华沙一村', '园西一居', '临丰小区', '青夏小区', '上浦小区']
    # Add the absolute path of the index.html on your laptop
    indexPath = 'C:/AAA/Git/MyDemos/Python3/soufangwang/frontend/index.html'
    # Config the absolute path of geckodriver.exe
    geckodriverPath = r'./drivers/geckodriver.exe'
    price = ''
    for area in areas:
        price = price + getPriceByAreaName(area) + ','
    price = price[:-1]
    filename = './data/data.json'
    content = '{' + price + '}'
    jsonObj = json.loads(content)
    createIndexHtml(jsonObj)
    driver = webdriver.Firefox(executable_path=geckodriverPath)
    driver.get("file:///" + indexPath)


if __name__ == '__main__':
    main()