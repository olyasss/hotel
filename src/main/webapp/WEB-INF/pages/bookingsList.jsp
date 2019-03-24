<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 20.03.2019
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Booking page</title>
</head>
<body>
<table >
    <tr>
        <th>№</th>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>e-mail</th>
        <th>телефон</th>
        <th>дата заселения</th>
        <th>дата выселения</th>
        <th>паспортные данные</th>
        <th>оплата</th>

    </tr>

    <c:forEach var="a" items="${book}">
        <tr>
            <td> ${a.id}</td>
            <td> ${a.user.name}</td>
            <td> ${a.user.surname}</td>
            <td> ${a.user.email}</td>
            <td> ${a.user.phone}</td>
            <td> ${a.dateFrom}</td>
            <td> ${a.dateTo}</td>
            <td> ${a.passport}</td>
            <td> ${a.paid}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="home">Главная</a></p>
<p><a href="users">Пользователи</a></p>
<p><a href="rooms">Комнаты</a></p>
</body>
</html>