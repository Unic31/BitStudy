import random as r
import turtle as t

#rnd=r.randint(1,100)#1부터 100사이의 난수
ws=t.Screen()
ws.colormode(255)
while True:
    x=int(input("x좌표 입력(종료:999):"))
    if x==999:
        print("프로그램 죵료")
        break
    y=int(input("y 좌표 입력:"))
    t.penup()
    t.shape("turtle")
    t.goto(x, y)

    red=r.randint(0,255)
    green=r.randint(0,255)
    blue=r.randint(0,255)


    t.color(red,green,blue)
    t.turtlesize(3)
    t.write("Good!",align="center",font=("Comic Sans MS",30,"bold"))
