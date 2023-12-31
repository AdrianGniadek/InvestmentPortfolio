<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Portfolio</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>Add Portfolio</h1>
    <form action="/add" method="post">
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>
        </div>
        <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <button type="submit">Add</button>
            <a href="/portfolios"><button type="button">Cancel</button></a>
        </div>
    </form>
    <c:if test="${register eq 'failed'}">
        <div>
            <p>Portfolio with this name already exists!</p>
        </div>
    </c:if>
</div>
</body>
</html>

