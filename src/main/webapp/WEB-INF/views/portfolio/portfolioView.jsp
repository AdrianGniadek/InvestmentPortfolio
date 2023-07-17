<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Portfolio</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1 class="center">Witaj w swoim portfolio: ${portfolio.getPortfolioName()}</h1>
    <a href="/portfolios" class="button">Przejdź do listy portfolio</a>
    <a href="/stock" class="button">Przejdź do swoich akcji</a>
</div>
</body>
</html>
