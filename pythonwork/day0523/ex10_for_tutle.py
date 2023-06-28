import turtle as t

t.color("pink")
t.begin_fill()#채우기색 시작
t.pencolor("blue")#펜 색상
t.width(5)#펜굵기
t.speed(1)#0~10 : 0은 10과 같이 가장 빠른 속도(1이 가장 느림)
t.shape("circle") #circle, classic, triangle, turtle
n=4
for x in range(n): #0~3
    t.fd(70)
    t.lt(360/n)
t.end_fill()#채우기 색 끝
t.exitonclick()