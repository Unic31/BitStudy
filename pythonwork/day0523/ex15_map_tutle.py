import  turtle as t
myshape={"반지름":"90","색상":"green","선굵기":"5","선색상":"purple"}

t.shape("turtle")
t.color(myshape.get("색상"))
t.pencolor(myshape.get("선색상"))
t.width(myshape.get("선굵기"))
t.begin_fill()#채우기
t.circle(int(myshape.get("반지름")))
t.end_fill()
t.exitonclick()