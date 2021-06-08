<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Логин</title>
</head>
<body>

<h1>Логин</h1>

<br><br>

<form name="user" method="post" action="/login">

    <label for="email" >Имя пользователя</label>
    <input type="email" id="email" name="username" value="gennadij.777@gmail.com" autofocus>

    <br>

    <label for="password">Пароль</label>
    <input type="password" id="password" name="password" value="1111" autofocus>

    <br>

    <#--noinspection FtlReferencesInspection-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <br>

    <br>

    <button type="submit" id="submit">Войти</button>

</form>




</body>
</html>