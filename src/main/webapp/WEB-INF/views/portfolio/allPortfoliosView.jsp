<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Portfolios</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <h1>All Portfolios</h1>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="portfolio" items="${portfolios}">
            <tr>
                <td>${portfolio.portfolioName}</td>
                <td>
                    <button onclick="location.href='/portfolio/edit/${portfolio.id}'">Edit</button>
                    <button onclick="location.href='/portfolio/delete/${portfolio.id}'">Delete</button>
                    <button onclick="location.href='/portfolio/switch/${portfolio.id}'">Switch</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>