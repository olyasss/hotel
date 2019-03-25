<%--
  Created by IntelliJ IDEA.
  User: Solovey
  Date: 25.03.2019
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Users page</title>
</head>
<body>

<form:form modelAttribute="userFromForm" method = "post" action="/hotel/registration/add" >
    <br>Login: <form:input path="login" />
    <br>Password: <form:input path="password"/>
    <br>Email: <form:input path="email"/>
    <br>Name: <form:input path="name"/>
    <br>Surname: <form:input path="surname"/>
    <br>Phone: <form:input path="phone"/>
    <br><form:button>register</form:button>
</form:form>


<p><a href="home">Главная</a></p>
<p><a href="rooms">Комнаты</a></p>
<p><a href="booking">Заказы</a></p>
</body>
</html>
