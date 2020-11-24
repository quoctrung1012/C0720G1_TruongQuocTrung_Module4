<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 23/11/2020
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/calculator" method="get">
    <input type="text" name="number1" placeholder="Number 1">
    <input type="text" name="number2" placeholder="Number 2"><br>
    <hr>
    <input type="submit" name="calculator" value="Addition(+)">
    <input type="submit" name="calculator" value="Subtraction(-)">
    <input type="submit" name="calculator" value="Multiplication(*)">
    <input type="submit" name="calculator" value="Division(/)">
    <hr>
</form>
<h3>Result : ${result}</h3>
</body>
</html>
