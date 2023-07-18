<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Portfolio</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1 class="center">Welcome to your portfolio: ${portfolio.getPortfolioName()}</h1>
    <a href="/portfolios" class="button">Go to portfolio list</a>
    <a href="/stock" class="button">Go to your stocks</a>
    <a href="/logout" class="button">Logout</a>
</div>
</body>
</html>
