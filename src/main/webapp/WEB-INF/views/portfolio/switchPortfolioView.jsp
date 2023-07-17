<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm Portfolio Switch</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<h1>Confirm Portfolio Switch</h1>
<p>Are you sure you want to switch to the portfolio: ${portfolio.portfolioName}?</p>
<form action="/portfolio/switch/${portfolio.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Confirm</button>
    <button onclick="location.href='/portfolios'" type="button">Cancel</button>
</form>
</body>
</html>
