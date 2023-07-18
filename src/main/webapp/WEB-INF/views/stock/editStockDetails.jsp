<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Stock Details</title>
    <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Edit Stock Details</h1>
<div class="container">
    <h2>${stock.name} (${stock.symbol})</h2>

    <h3>Edit Portfolio Asset Details</h3>
    <form action="/stock/editDetails/${stock.id}" method="post">
        <table>
            <tr>
                <th>Quantity</th>
                <th>Asset Value</th>
                <th>Purchase Date</th>
            </tr>
            <c:forEach var="portfolioAsset" items="${portfolioAssets}">
                <tr>
                    <td><input type="number" name="quantity" value="${portfolioAsset.quantity}" required></td>
                    <td><input type="number" name="assetValue" value="${portfolioAsset.assetValue}" step="0.01" required></td>
                    <td><input type="text" name="purchaseDate" value="${portfolioAsset.purchaseDate}" required></td>
                </tr>
                <input type="hidden" name="portfolioAssetId" value="${portfolioAsset.id}">
            </c:forEach>
        </table>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Save">
        <button type="button" onclick="location.href='/stock/stockDetails/${stock.id}'">Cancel</button>
    </form>
</div>
</body>
</html>