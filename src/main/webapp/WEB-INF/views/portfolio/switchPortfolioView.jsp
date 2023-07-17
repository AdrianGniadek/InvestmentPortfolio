<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Portfolio Switch</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Confirm Portfolio Switch</h1>
    <p>Are you sure you want to switch to the portfolio: ${portfolio.portfolioName}?</p>
    <form action="/portfolio/switch/${portfolio.id}" method="post">
        <button type="submit">Confirm</button>
        <button onclick="location.href='/portfolios'" type="button">Cancel</button>
    </form>
</div>
</body>
</html>
