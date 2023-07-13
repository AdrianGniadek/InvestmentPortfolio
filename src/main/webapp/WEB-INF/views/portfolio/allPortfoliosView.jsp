<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Portfolios</title>
</head>
<body>
<h1>All Portfolios</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="portfolio" items="${portfolios}">
        <tr>
            <td>${portfolio.portfolioName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>