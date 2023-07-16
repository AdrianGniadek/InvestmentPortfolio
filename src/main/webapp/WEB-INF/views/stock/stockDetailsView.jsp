<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Details</title>
</head>
<body>
<h1>Stock Details</h1>
<h2>${stock.name} (${stock.symbol})</h2>

<h3>Portfolio Asset Details</h3>
<table>
    <tr>
        <th>Quantity</th>
        <th>Asset Value</th>
        <th>Purchase Date</th>
    </tr>
    <c:forEach var="portfolioAsset" items="${portfolioAssets}">
        <tr>
            <td>${portfolioAsset.quantity}</td>
            <td>${portfolioAsset.assetValue}</td>
            <td>${portfolioAsset.purchaseDate}</td>
        </tr>
    </c:forEach>
</table>
<a href="/stock/addDetails?stockId=${stock.id}">Add Details</a>
<a href="/stock">Return</a>
</body>
</html>