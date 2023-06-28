for n in range(1,10,2): #1~9까지 2씩 증가
    print(n,end=" ")#1 3 5 7 9
print()
for n in range(10,100,10):
    print(n,end=" ")
print()

for n in ["apple","banana","orange"]: #리스트의 각 값이 n으로 넘어간다
    print(n,end=" ")
print()

list=["red","green","blue","white"]
for n in list:
    print(list.index(n),":",n) #인덱스는 각 번호(0부터)
print()

myBook={"책이름":"모두의 파이썬","출판사":"가메출판사","가격":23000}
for n in myBook: #n:키값이 넘어간다
    print(n,":",myBook.get(n))