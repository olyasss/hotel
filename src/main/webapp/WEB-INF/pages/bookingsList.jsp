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
    <link rel="stylesheet" href="res/css/style.css" type="text/css">
    <title>Booking page</title>
</head>
<body>

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
        </tr>
    </c:forEach>
</table>
    <form action="/hotel/booking/delete" method="post">
        Number: <input name="bookingId" type="number" min="1"/>
        <input type="submit" value="submit" />
    </form>
</div>

</body>
</html>