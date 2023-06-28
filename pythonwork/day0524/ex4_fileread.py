print("** C:/bit701naver/js변수선언.txt **")
f1=open("C:/bit701naver/js변수선언.txt","r",encoding="UTF8")

s2=f1.readlines()
f1.close()
# print(s2)

for data in s2:
    print(data)