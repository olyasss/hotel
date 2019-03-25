<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 25.03.2019
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Booking page</title>
</head>
<body>

<form:form modelAttribute="dateForm" method="post" action="/hotel/bookingroom/date">
    <br>date from <form:label  path="dateFrom" id="1" />
    <input type="date" form="1"/>
    <br>date to <form:label path="dateTo" id="2"/>
    <input type="date" form="2">
    <br><form:button>booking</form:button>

</form:form>

<br>
<br>
<h2>Free rooms</h2>
<table >
    <tr>
        <th>№</th>
        <th>Номер</th>
        <th>Этаж</th>
        <th>Тип комнаты</th>
        <th>Цена</th>
        <th>Описание</th>
    </tr>

    <c:forEach var="a" items="${freeRoomsList}">

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

<br>
<br>
<form:form modelAttribute="roomNumber" method = "post" action="/hotel/bookingroom/book">
    <br><form:label path="roomNumber" id="3"/>
    Room number <input type="number" form="3"/>
    <br><form:button>booking</form:button>
</form:form>

<p><a href="home">Главная</a></p>
<p><a href="users">Пользователи</a></p>
<p><a href="rooms">Комнаты</a></p>
</body>
</html>