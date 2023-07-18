<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Details</title>
    <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Stock Details</h1>
<div class="container">
    <h2>${stock.name} (${stock.symbol})</h2>

    <h3>Portfolio Asset Details</h3>
    <table>
        <tr>
            <th>Quantity</th>
            <th>Asset Value</th>
            <th>Purchase Date</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="portfolioAsset" items="${portfolioAssets}">
            <tr>
                <td>${portfolioAsset.quantity}</td>
                <td>${portfolioAsset.assetValue}</td>
                <td>${portfolioAsset.purchaseDate}</td>
                <td>
                <a href="/stock/editDetails/${stock.id}"><button type="button">Edit</button></a>
                <a href="/stock/deleteDetails/${stock.id}"><button type="button">Delete</button></a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button type="button" onclick="location.href='/stock/addDetails?stockId=${stock.id}'">Add details</button><br>
    <button type="button" onclick="location.href='/stock'">Return</button>
</div>
</body>
</html>