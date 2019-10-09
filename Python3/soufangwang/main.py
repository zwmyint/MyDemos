from selenium import webdriver
from fangtianxia import getPriceByAreaName
from fileutil import write



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
    write(filename, content)
    
    driver = webdriver.Firefox(executable_path=geckodriverPath)
    driver.get("file:///" + indexPath)


if __name__ == '__main__':
    main()