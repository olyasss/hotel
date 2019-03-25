<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Index page</title>
</head>
<br>
<h1>Hello</h1>
<h5>Пользователь: ${message} </h5>
<h5><c:out value="${userSession.login}"/></h5>

<form:form modelAttribute="log" method="post" action="/hotel/home/dologin">
    login: <form:input path="login"/>
    password: <form:input path="password"/>
    <form:button>log in</form:button>
</form:form>
<br><button><a href="registration">registration</a></button>



<p><a href="users">Пользователи</a></p>
<p><a href="rooms">Комнаты</a></p>
<p><a href="booking">Заказы</a></p>
<p><a href="bookingroom">Забронировать номер</a></p>
</body>
</html>