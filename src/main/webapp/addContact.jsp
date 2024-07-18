<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Contact</title>
    <style>
        /* CSS styles for the addContact.jsp page */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 500px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .error {
            color: red;
            margin-bottom: 10px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #555;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Contact</h2>
        <c:if test="${not empty requestScope.errorMessage}">
            <p class="error"><c:out value="${requestScope.errorMessage}"/></p>
        </c:if>
        <form action="AddContact" method="post">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>
            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone" required>
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <button type="submit">Add Contact</button>
        </form>
    </div>
</body>
</html>
