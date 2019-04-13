<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 26.02.2019
  Time: 22:29
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
    <link rel="stylesheet" href="res/css/style.css" type="text/css">
    <title>Users page</title>
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
    <form action="/hotel/users/delete" method="post">
        Number: <input name="userId" type="number" min="1"/>
        <input type="submit" value="submit" />
    </form>
</div>

</body>
</html>