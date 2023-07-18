<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Edit</title>
  <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Edit Stock</h1>
<div class="container">
  <form action="/stock/edit/${stock.id}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${stock.name}" required><br><br>
    <label for="symbol">Symbol:</label>
    <input type="text" id="symbol" name="symbol" value="${stock.symbol}" required><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Save Changes</button>
    <button type="button" onclick="location.href='/stock'">Cancel</button>
  </form>
</div>
</body>
</html>
