<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Stocks</title>
    <link rel="stylesheet" type="text/css" href="../../../style.css">
</head>
<body>
<h1>All Stocks</h1>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>Symbol</th>
            <th>Name</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="stock" items="${stocks}">
            <tr>
                <td>${stock.symbol}</td>
                <td>${stock.name}</td>
                <td>
                    <a href="/stock/addDetails?stockId=${stock.id}">
                        <button type="button">Add details</button>
                    </a>
                    <button type="button" onclick="location.href='/stock/stockDetails/${stock.id}'">Show details</button>
                    <a href="/stock/edit/${stock.id}">
                        <button type="button">Edit</button>
                    </a>
                    <a href="/stock/delete/${stock.id}">
                        <button type="button">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="button" onclick="location.href='/stock/add'">Add stock</button><br>
    <button type="button" onclick="location.href='/'">Return</button>
</div>
</body>
</html>
