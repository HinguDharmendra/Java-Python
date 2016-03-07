import turtle

#pull the pen down while drawing
turtle.pendown()
turtle.pd()
turtle.down()

#pull the pen up while drawing
turtle.penup()
turtle.pu()
turtle.up()

turtle.down()
#turtle.speed(1)
print turtle.pensize()
turtle.pensize(10)
turtle.fd(100)
turtle.width(5)
turtle.pen(pencolor='red')
turtle.bk(200)

print sorted(turtle.pen().items())
print turtle.isdown()
turtle.up()
print turtle.isdown()

turtle.pencolor('yellow')
print turtle.colormode()
turtle.width(1)
turtle.fillcolor('blue')
turtle.color('red', 'green')

turtle.reset()
turtle.goto(100,100)
turtle.clear()

turtle.write('Home = ', True, align='center')
x=turtle.xcor()
y=turtle.ycor()
turtle.write((x,y), True)

turtle.exitonclick()
