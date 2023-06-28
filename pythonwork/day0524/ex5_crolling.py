
# C:\Users\uenic\AppData\Local\Programs\Python\Python311\Scripts
# pip3 install requests
# pip3 install vendor


import requests
req=requests.get("https://cafe.naver.com/zipsy")

#html 소스 가져오기
html=req.text

#http header 가져오기
header=req.headers

#http status 가져오기(200:ok)
status=req.status_code

#http가 정상적으로 되었는지(True/False)
is_ok=req.ok

# print("**html**")
# print(html)

# print("**header**")
# print(header)

print("**status**")
print(status)

print("**is_ok**")
print(is_ok)