<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23/11/2020
  Time: 11:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator">
    <input type="text" name="number1" placeholder="Number 1">
    <input type="text" name="number2" placeholder="Number 2"><br>
    <hr>
    <input type="submit" value="Addition(+)">
    <input type="submit" value="Subtraction(-)">
    <input type="submit" value="Multiplication(*)">
    <input type="submit" value="Division(/)">
    <hr>
  </form>
<%--  <h3>Result : ${result}</h3>--%>
  </body>
</html>
