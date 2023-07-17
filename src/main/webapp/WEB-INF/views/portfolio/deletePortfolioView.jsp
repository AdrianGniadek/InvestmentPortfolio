<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Portfolio</title>
</head>
<body>
<h1>Delete Portfolio</h1>
<p>Are you sure you want to delete the portfolio "${portfolio.portfolioName}"?</p>
<form action="/portfolio/delete/${portfolio.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Delete">
    <button onclick="location.href='/portfolios'" type="button">Cancel</button>
</form>
</body>
</html>
