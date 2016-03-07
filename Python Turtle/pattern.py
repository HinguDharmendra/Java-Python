import turtle

turtle.width(3)
turtle.shape('turtle')
turtle.shapesize(1,1,1)

turtle.circle(20)
turtle.color('yellow')
turtle.bk(100)
turtle.fd(300)

turtle.up()
turtle.goto(20,20)
turtle.down()
turtle.left(90)

turtle.color('red')
turtle.bk(100)
turtle.fd(300)

turtle.up()
turtle.goto(0,40)
turtle.down()
turtle.left(90)

turtle.color('green')
turtle.bk(100)
turtle.fd(300)

turtle.up()
turtle.goto(-20,20)
turtle.down()
turtle.left(90)

turtle.color('blue')
turtle.bk(100)
turtle.fd(300)

turtle.color('yellow')
turtle.up()
turtle.home()
turtle.goto(70,-40)
turtle.down()
turtle.circle(20)
turtle.stamp()

turtle.color('red')
turtle.up()
turtle.home()
turtle.goto(40,70)
turtle.down()
turtle.circle(20)
turtle.stamp()

turtle.color('green')
turtle.up()
turtle.home()
turtle.goto(-70,40)
turtle.down()
turtle.circle(20)
turtle.stamp()

turtle.color('blue')
turtle.up()
turtle.home()
turtle.goto(-40,-70)
turtle.down()
turtle.circle(20)
turtle.stamp()

turtle.up()
turtle.color('black')
turtle.home()

turtle.exitonclick()
