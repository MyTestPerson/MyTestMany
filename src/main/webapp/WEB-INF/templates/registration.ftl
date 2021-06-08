<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>
</head>
<body>


<br><br>

<form name="user" method="post" action="/registration">

    <label for="email" >Адрес электронной почты</label>
    <input type="email" id="email" name="email" value="gennadij.777@gmail.com" autofocus>

    <br>
    <br>

    <label for="password">Пароль</label>
    <input type="password" id="password" name="password" value="1111" autofocus>
    <br>

    <#--noinspection FtlReferencesInspection-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <br>
    <br>

    <button type="submit" id="submit">Зарегистрироваться</button>

</form>

<br><br>

<a href="/login"><b>Уже есть аккаунт?</b></a><br>

<br><br>

</body>
</html>