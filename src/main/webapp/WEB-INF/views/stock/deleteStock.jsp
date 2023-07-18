<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Delete Stock</title>
  <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Delete Stock</h1>
<div class="container">
  <p>Are you sure you want to delete the stock "${stock.name}" (${stock.symbol})?</p>
  <form action="/stock/delete/${stock.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Delete</button>
    <button type="button" onclick="location.href='/stock'">Cancel</button>
  </form>
</div>
</body>
</html>
