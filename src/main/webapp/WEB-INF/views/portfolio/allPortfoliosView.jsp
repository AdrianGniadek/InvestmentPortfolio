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
            <th>Description</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="portfolio" items="${portfolios}">
            <tr>
                <td>${portfolio.portfolioName}</td>
                <td>${portfolio.description}</td>
                <td class="actions">
                    <a href="/portfolio/edit/${portfolio.id}">Edit</a>
                    <a href="/portfolio/delete/${portfolio.id}">Delete</a>
                    <a href="/portfolio/switch/${portfolio.id}">Switch</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/" class="button">Return</a>
</div>
</body>
</html>
