<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/11/2020
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: green; text-align: center" >${message}</h3>
<form:form modelAttribute="emailSetting" >
    <table>
        <tr>
            <th>Language</th>
            <td><form:input path="languages" disabled="true"/> </td>
        </tr>
        <tr>
            <th>pageSize</th>
            <td><form:input path="pageSize" disabled="true"/> </td>
        </tr>
        <tr>
            <th>Spams Fitter</th>
            <td><form:input path="spamFitter" disabled="true"/> </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td><form:input path="signature" disabled="true"/> </td>
        </tr>
        <tr>
            <th></th>
            <td><a href="/save"><button>Back Setting</button></a></td>
        </tr>
    </table>
</form:form>

</body>
</html>
