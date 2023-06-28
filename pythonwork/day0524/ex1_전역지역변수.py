def test():
    a=5 #지역변수

def test2():
    global b #모든 함수에서 이용 가능한 전역변수
    b=10

def test3():
    print("b=",b)

# test()
# print("a=",a)   #a는 test()함수 안에서만 사용 가능한 변수 이므로 선언 안됐다는 오류 나옴

a=10
test()
print("a=",a) #10

test2()
print("b=",b)
test3()