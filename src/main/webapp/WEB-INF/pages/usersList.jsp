<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 26.02.2019
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users page</title>
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
        <th>Телефон</th>
    </tr>

    <c:forEach var="a" items="${users}">
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
<p><a href="index.jsp">Главная</a></p>
<p><a href="rooms">Комнаты</a></p>
<p><a href="booking">Заказы</a></p>
</body>
</html>