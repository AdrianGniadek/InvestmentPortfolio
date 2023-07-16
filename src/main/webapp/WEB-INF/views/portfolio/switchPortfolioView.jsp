<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Switch Portfolio</title>
</head>
<body>
<h1>Switch Portfolio</h1>
<p>Are you sure you want to switch to the portfolio "${portfolio.name}"?</p>
<form action="/portfolio/switch/{id}" method="get">
    <input type="submit" value="Switch">
</form>
</body>
</html>
