<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Админ</title>
</head>
<body>

<h1>Страница админа</h1>

<br><br><br><br>

<a href="/"><b>Главная</b></a>

<br><br>

<form method="post" action="/logout">
    <#--noinspection FtlReferencesInspection-->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Выход</button>
</form>

</body>
</html>