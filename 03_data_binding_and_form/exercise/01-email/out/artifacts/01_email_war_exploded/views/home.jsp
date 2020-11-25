<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/11/2020
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/save" method="get" modelAttribute="emailSetting">
    <table border="1">
        <tr>
            <th><form:label path="languages">Language</form:label>
            <td><form:select path="languages" items="${language}"/></td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Paper Size</form:label></th>
            <td>><form:select path="pageSize" items="${paperSize}"/></td
        </tr>
        <tr>
            <th><form:label path="spamFitter">Spams Fitter</form:label></th>
            <td><form:checkbox path="spamFitter"/>Enable Spams Fitter</td>
        </tr>
        <tr>
            <th><form:label path="signature">Signature</form:label>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <th></th>
            <td><form:button>Save</form:button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
