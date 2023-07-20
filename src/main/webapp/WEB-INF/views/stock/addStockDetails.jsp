<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Stock Details</title>
    <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Add Stock Details</h1>
<div class="container">
    <h2>${stock.name} (${stock.symbol})</h2>

    <form method="POST">
        <input type="hidden" name="stockId" value="${stock.id}">
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" step="1" min="0"><br><br>
        <label for="assetValue">Stock Price:</label>
        <input type="number" id="assetValue" name="assetValue" step="0.01" min="0"
               placeholder="Enter Stock Price" required><br><br>
        <label for="purchaseDate">Purchase Date:</label>
        <input type="date" id="purchaseDate" name="purchaseDate" pattern="\d{2}\.\d{2}\.\d{4}" required><br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Add Details">
        <button type="button" onclick="location.href='/stock'">Return</button><br>
    </form>
</div>
</body>
</html>
