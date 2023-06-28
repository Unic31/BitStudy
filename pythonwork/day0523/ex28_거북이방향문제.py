"""
list에 10개 정도의 색상을 넣어놓고
방향키를 움직일때마다 랜덤 색상으로 거북이가 해당 방향으로 10씩 이동하도록 한다
거북이 크기 등 모두 자유
스페이스 누르면 색상변경
"""
import turtle as t
import random

list=["red","orange","yellow","green","blue","purple","pink"]
t.shape("turtle")
t.turtlesize(1)
t.width(1)




def key_up():
    t.setheading(90)#위
    t.fd(10)
def key_down():
    t.setheading(270)  # 아래
    t.fd(10)
def key_left():
    t.setheading(180)  # 왼
    t.fd(10)
def key_right():
    t.setheading(360)  # 오른쪽
    t.fd(10)
def key_sp():
    idx = random.randint(0, 6)
    t.color(list[idx])


t.onkeypress(key_up, "Up")  # 호출 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_down, "Down")  # 호출 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_left, "Left")  # 호출 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_right, "Right")  # 호출 함수명, 키값(첫글자 반드시 대문자)
t.onkeypress(key_sp, "space")  # 호출 함수명, 키값(첫글자 반드시 대문자)
t.listen()


t.exitonclick()


