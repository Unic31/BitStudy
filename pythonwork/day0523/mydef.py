import random as rnd
def mystar(n):
    for n in range(1,n+1):
        for i in range(1,n+1):
            print("☆",end="")
        print()
    print("="*40)

#turtle 값을 인자로 받아서 색상과 크기를 랜덤하게 만드는 함수
def showturtle(tt):
    tt.penup()
    tt.shape("turtle")
    r=rnd.randint(1,255)
    g=rnd.randint(1,255)
    b=rnd.randint(1,255)
    ts=rnd.randint(2,5)

    tt.color(r,g,b)#거북이 색상 변경
    tt.turtlesize(ts)#거북이 크기 변경

    #위치 랜덤
    x=rnd.randint(-200,200)
    y=rnd.randint(-200,200)
    tt.goto(x,y)