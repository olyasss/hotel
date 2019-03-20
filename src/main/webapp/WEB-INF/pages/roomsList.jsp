<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 20.03.2019
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rooms page</title>
</head>
<body>
<table >
    <tr>
        <th>№</th>
        <th>Номер</th>
        <th>Этаж</th>
        <th>Тип комнаты</th>
        <th>Цена</th>
        <th>Описание</th>
    </tr>

    <c:forEach var="a" items="${rooms}">

        <tr>
            <td> ${a.id}</td>
            <td> ${a.number}</td>
            <td> ${a.floor}</td>
            <td> ${a.price.typeRoom}</td>
            <td> ${a.price.cost}</td>
            <td> ${a.description}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="index.jsp">Главная</a></p>
<p><a href="users">Пользователи</a></p>
<p><a href="booking">Заказы</a></p>
</body>
</html>