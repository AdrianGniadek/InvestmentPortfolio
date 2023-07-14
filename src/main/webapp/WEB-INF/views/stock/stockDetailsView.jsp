<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Details</title>
</head>
<body>
<h1>Stock Details</h1>
<h2>${stock.name} (${stock.symbol})</h2>

<h3>Purchase History</h3>
<table>
    <thead>
    <tr>
        <th>Date</th>
        <th>Quantity</th>
        <th>Asset Value</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="purchase" items="${portfolioAsset.purchases}">
        <tr>
            <td>${purchase.purchaseDate}</td>
            <td>${purchase.quantity}</td>
            <td>${purchase.assetValue}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/stock/addDetails?stockId=${stock.id}">Add Details</a>
</body>
</html>