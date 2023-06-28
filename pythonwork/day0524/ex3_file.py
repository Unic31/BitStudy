"""
파일변수=open("파일명","모드")
모드 : w:쓰기 r:읽기 a:추가
"""
import os
print(os.path.isfile("c:/data1.txt")) #파일이 존재하면 true 없으면 false
print(os.path.isdir("c:/bit701naver")) #폴더가 존재하면 true 없으면 false

f1=open("c:/bit701naver/data1.txt","w")
str="hello\npython\nspring boot"
f1.write(str)
f1.close()

print("data1.txt 확인")

f2=open("c:/bit701naver/data2.txt","w")
str2="안녕하세요\n파이썬 공부중입니다"
f2.writelines(str2)
f2.close()

print("data2.txt 확인")

f3=open("c:/bit701naver/data3.txt","w")
list=["빨강색\n","노랑색\n","분홍색\n","초록색"]
#f3.write(list) #TypeError: write() argument must be str, not list
f3.writelines(list)
f3.close()

print("data3.txt 확인")


