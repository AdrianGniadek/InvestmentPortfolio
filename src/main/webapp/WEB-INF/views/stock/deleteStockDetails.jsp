<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Delete Stock Details</title>
  <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>Delete Stock Details</h1>
<div class="container">
  <h2>${stock.name} (${stock.symbol})</h2>
  <h3>Confirm Deletion</h3>
  <p>Are you sure you want to delete the following portfolio asset?</p>
  <form action="/stock/deleteDetails/${stock.id}" method="post">
    <input type="hidden" name="portfolioAssetId" value="${portfolioAsset.id}">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="Delete">
    <button type="button" onclick="location.href='/stock/stockDetails/${stock.id}'">Cancel</button>
  </form>
</div>
</body>
</html>