<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit portfolio</title>
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
<h1>Edit portfolio</h1>
<form action="/portfolio/edit/${portfolio.id}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${portfolio.portfolioName}" required><br><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${portfolio.description}"><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Save">
</form>
</body>
</html>
