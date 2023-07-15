<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Stock Details</title>
</head>
<body>
<h1>Add Stock Details</h1>
<h2>${stock.name} (${stock.symbol})</h2>

<form method="POST">
    <input type="hidden" name="stockId" value="${stock.id}">
    <label for="quantity">Quantity:</label>
    <input type="number" id="quantity" name="quantity"><br><br>
    <label for="assetValue">Asset Value:</label>
    <input type="number" id="assetValue" name="assetValue"><br><br>
    <label for="purchaseDate">Purchase Date:</label>
    <input type="text" id="purchaseDate" name="purchaseDate"><br><br>
    <input type="submit" value="Add Details">
</form>
</body>
</html>
