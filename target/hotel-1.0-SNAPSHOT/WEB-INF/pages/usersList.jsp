<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 26.02.2019
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
</head>
<body>
<table >
    <tr>
        <th>№</th>
        <th>Логин</th>
        <th>Пароль</th>
        <th>e-mail</th>
        <th>Имя</th>
        <th>Фамилия</th>
    </tr>

    <c:forEach items="#{requestScope.usersList}" var="a">
        <tr>
            <td> ${a.id}</td>
            <td> ${a.login}</td>
            <td> ${a.password}</td>
            <td> ${a.email}</td>
            <td> ${a.name}</td>
            <td> ${a.surname}</td>
            <td> ${a.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
