import turtle
colors=["red","purple","pink","green","orange","gray","yellow"]
t=turtle.Turtle()

turtle.bgcolor("black") #배경 색
t.speed(0)#가장 빠른 속도
t.width(3)
length=10#변수

#반복문 while 들여쓰기를 벗어나면 while 끝나고 실행될 코드
while length<500:
    t.forward(length)
    t.pencolor(colors[length%7])
    t.right(144)
    length+=5
turtle.exitonclick()