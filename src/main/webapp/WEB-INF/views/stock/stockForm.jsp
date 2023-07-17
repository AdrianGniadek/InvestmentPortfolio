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

        <label for="price">Price:</label>
        <input type="text" id="price" name="price" required><br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button type="submit">Submit</button>
        <button type="button" onclick="location.href='/stock'">Return</button>
    </form>
</div>
</body>