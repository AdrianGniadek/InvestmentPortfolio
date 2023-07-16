<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Portfolio</title>
</head>
<body>
<h1>Delete Portfolio</h1>
<p>Are you sure you want to delete the portfolio "${portfolio.portfolioName}"?</p>
<form action="/portfolio/delete/{id}" method="get">
    <input type="submit" value="Delete">
</form>
</body>
</html>
