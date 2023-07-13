<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Stock Form</title>
</head>
<body>
<h1>Add Stock</h1>
<form action="/stock" method="post">
    <label for="symbol">Symbol:</label>
    <input type="text" id="symbol" name="symbol" required><br>

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="price">Price:</label>
    <input type="text" id="price" name="price" required><br>

    <button type="submit">Submit</button>
</form>
</body>
