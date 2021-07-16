import time
from idlelib import browser

import pandas as pd
import requests
from bs4 import BeautifulSoup
from selenium import webdriver

driver = webdriver.Chrome("C:/Users/KB/Downloads/chromedriver")

driver.get("http://www.cgv.co.kr/reserve/show-times/?areacode=11&theaterCode=0157&date=20210702")
citySelBtn = driver.find_element_by_xpath('//*[@id="contents"]/div[1]/div/div[2]/ul/li[6]/a')
citySelBtn.click()
storeSelBtn = driver.find_element_by_xpath('//*[@id="contents"]/div[1]/div/div[2]/ul/li[6]/div/ul/li[2]/a')
storeSelBtn.click()
iframes = driver.find_element_by_css_selector('iframe')
driver.switch_to.frame("ifrm_movie_time_table")
html = driver.page_source
soup = BeautifulSoup(html, "html.parser")

strong = soup.find_all("strong")
movieSrc = soup.select("body > div > div.sect-showtimes > ul > li")
dic = {}
time_table = []

for x in movieSrc:
    time_table.append(x.find("div", {"class": "info-timetable"}).find_all("em"))

for x in time_table:
    count = 0
    for y in x:
        x[count] = y.text
        count += 1

for x in movieSrc:
    dic[x.find("strong").text.replace("\n", "").replace(" ", "")] = x.find("div", {"class": "info-timetable"}).find_all(
        "em")

time_table
lala = []
count = 0
for x in movieSrc:
    dic = {}
    dic['Movie'] = x.find("strong").text.replace("\n", "").replace(" ", "")
    dic['time'] = time_table[count]
    count += 1

    lala.append(dic)
print(lala)
data = pd.DataFrame(lala, columns=['MOVIE','time'])
print(data)
result_file = pd.DataFrame({'movieTitle':lst2, 'score':lst1})
result_file.to_csv("C:\\Users\\KB\\Documents\\R\\result.csv", index=False,
                   encoding='euc-kr')
print(result_file)
time.sleep(5)  # 5초 대기
driver.quit()
