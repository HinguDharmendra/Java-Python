import turtle
turtle.speed('normal')
turtle.color('blue')
b=turtle.stamp()
turtle.fd(100)
turtle.right(-90)
turtle.color('red')
r=turtle.stamp()
turtle.fd(100)
turtle.right(-90)
turtle.color('green')
g=turtle.stamp()
turtle.fd(100)
turtle.right(-90)
turtle.color('yellow')
y=turtle.stamp()
turtle.fd(100)
turtle.right(-90)
turtle.color('black')


turtle.speed(1)
turtle.color('blue')
b=turtle.stamp()
turtle.fd(100)
turtle.right(90)
turtle.color('red')
r=turtle.stamp()
turtle.fd(100)
turtle.right(90)
turtle.color('green')
g=turtle.stamp()
turtle.fd(100)
turtle.right(90)
turtle.color('yellow')
y=turtle.stamp()
turtle.fd(100)
turtle.right(90)
turtle.color('black')

turtle.clearstamp(y)
turtle.clearstamp(g)
turtle.clearstamp(r)
turtle.clearstamp(b)

turtle.undo()
turtle.exitonclick()