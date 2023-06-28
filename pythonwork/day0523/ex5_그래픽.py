import turtle as t
wn=t.Screen() #그래픽창
wn.setup(600,600,0,0)#width,height,x,y
t.width(3)
# wn.colormode(1.0)
# t.color(0,1.0,0.3)

t.shape("turtle")
wn.colormode(255)
t.color(255,0,255)
t.fd(100)#포워드, 앞으로 n만큼
t.lt(120)
t.fd(100)
t.lt(120)
t.fd(120)
t.circle(100)

t.exitonclick()
