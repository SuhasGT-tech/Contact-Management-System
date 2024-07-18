<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage User</title>
    <link rel="stylesheet" href="/css/styles.css"> 
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .container {
            margin-top: 20px;
        }
        .button-group a {
            display: inline-block;
            padding: 10px 20px;
            margin: 5px;
            text-decoration: none;
            color: white;
            background-color: #007BFF;
            border-radius: 5px;
        }
        .button-group a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Manage User</h1>
    <div class="container">
        <div class="button-group">
            <a href="updateUser.jsp">Update User</a>
            <a href="DeleteUserServlet">Delete Your Account</a> <!-- Updated for deleting user -->
        </div>
    </div>
</body>
</html>
