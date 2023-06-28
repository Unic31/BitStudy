import requests
from bs4 import BeautifulSoup

req=requests.get("https://search.naver.com/search.naver?where=image&sm=tab_jum&query=newjeans")

html=req.text

#html 소스를 파이썬 객체로 변환하기
soup=BeautifulSoup(html,'html.parser')

#selector 를 통해서 html 요소를 찾아낸다
tiles=soup.select("div.photo_bx a img")
print(tiles)

# for atag in tiles:
#     print(tiles.index(atag),":",atag.text)