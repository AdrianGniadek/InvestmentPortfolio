<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Stocks</title>
</head>
<body>
<h1>All Stocks</h1>
<table>
    <thead>
    <tr>
        <th>Symbol</th>
        <th>Name</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="stock" items="${stocks}">
        <tr>
            <td>${stock.symbol}</td>
            <td>${stock.name}</td>
            <td>${stock.price}</td>
            <td><a href="/stock/details?stockId=${stock.id}">Wyświetl szczegóły</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/stock/add">Dodaj akcję</a>
</body>
</html>