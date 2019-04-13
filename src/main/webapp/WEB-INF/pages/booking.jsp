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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="res/css/style.css" type="text/css">
    <title>Booking page</title>
</head>
<body>
<jsp:useBean id="date" class="by.solovei.hotel.models.DateInfo"/>

<div class="block1">
    <h5>${user_session.login} </h5>
</div>

<div class="block2">
    <p><a href="home"><img src="res/buttons/home.jpg"></a></p>
    <p><a href="bookingroom"><img src="res/buttons/booking.jpg"></a></p>
    <p><a href="booking"><img src="res/buttons/bookingList.jpg"></a></p>
    <p><a href="users"><img src="res/buttons/userList.jpg"></a></p>
</div>

<div class="block3">
<form action="/hotel/bookingroom/date" method="post" id="date">
    date from: <input name="dateFrom"/>
    date from: <input name="dateTo"/>
    <input type="submit" value="submit" />
</form>

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
<form action="/hotel/bookingroom/book" method="post">
    Number: <input name="roomNumber" type="number" min="1"/>
    Passport: <input name="passport" type="text">
    <input type="submit" value="submit" />
</form>

<h3><c:out value="${info}"/></h3>

</div>
</body>
</html>