import turtle
p=100
while(p>0):
    if(p==10 or p==30 or p==50 or p==70 or p==90):
        turtle.color('red')
    if(p==20 or p==40 or p==60 or p==80 or p==100):
        turtle.color('yellow')    
    turtle.ht()
    turtle.st()
    p=p-1
print turtle.isvisible()

turtle.exitonclick()
