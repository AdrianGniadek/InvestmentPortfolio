<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="form-container">
        <h1>Register</h1>
        <form action="/register" method="post">
            <div>
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div>
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div>
                <label for="confirm">Confirm:</label>
                <input type="password" id="confirm" name="confirm"/>
            </div>
            <button type="submit">Register</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <c:if test="${register eq 'failed'}">
            <div>
                <p>Registration failed. User with this username already exists.</p>
            </div>
        </c:if>

        <c:if test="${pass eq 'failed'}">
            <div>
                <p>Passwords do not match.</p>
            </div>
        </c:if>
    </div>
</div>
</body>
</html>
