<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Portfolio</title>
</head>
<body>
<h1>Edit Portfolio</h1>
<form action="/portfolio/edit/${portfolio.id}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${portfolio.portfolioName}" required>
    <br>
    <input type="submit" value="Save">
</form>
</body>
</html>
