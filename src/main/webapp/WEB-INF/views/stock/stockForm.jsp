<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Form</title>
    <link rel="stylesheet" type="text/css" href="../../../style.css">

</head>
<body>
<h1>Add Stock</h1>
<div class="container">
    <form method="post">
        <label for="symbol">Symbol:</label>
        <input type="text" id="symbol" name="symbol" required><br><br>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Submit</button>
        <button type="button" onclick="location.href='/stock'">Return</button>
    </form><br>
    <c:if test="${not empty symbolError}">
        <span>${symbolError}</span><br>
    </c:if>

    <c:if test="${not empty nameError}">
        <span>${nameError}</span><br>
    </c:if>
</div>
</body>