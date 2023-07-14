<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Form</title>
</head>
<body>
<h1>Add Stock</h1>
<form method="post">
    <label for="symbol">Symbol:</label>
    <input type="text" id="symbol" name="symbol" required><br><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" required><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit">Submit</button>
</form>
</body>