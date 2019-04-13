<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="res/css/style.css" type="text/css">
    <title>Index page</title>
</head>
<div class="block1"><h5> ${user_session.login} </h5>
<form:form modelAttribute="log" method="post" action="/hotel/home/dologin">
    login:    <form:input path="login" cssStyle="align-self: end"/>
    password: <form:input path="password" cssStyle="align-self: end" />
    <form:button >log in</form:button>
</form:form>
<button class="registration" type="button"><a href="registration">registration</a></button>
</div>

<div class="block2">
    <p><a href="home"><img src="res/buttons/home.jpg"></a></p>
    <p><a href="bookingroom"><img src="res/buttons/booking.jpg"></a></p>
    <p><a href="booking"><img src="res/buttons/bookingList.jpg"></a></p>
    <p><a href="users"><img src="res/buttons/userList.jpg"></a></p>
</div>

<div class="block3">
    На побережье Мареммы, среди нетронутых пляжей и лазури морской воды, небольших бухточек и грозных скал, среди средневековых башен и богатой растительности, возвышается отель Resort Baia Scarlino.
    Отель расположился напротив Тосканского архипелага, в умиротворенном уголке, где находится оснащённый туристический порт.
    Его просторные однокомнатные и двукомнатные сьюты выходят непосредственно к туристическому порту Марина-ди-Скарлино. Отель находится на расстоянии 100 км от аэропорта Пизы.

</div>

</body>
</html>