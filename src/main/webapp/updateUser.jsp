<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ex.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link rel="stylesheet" href="/css/styles.css"> <!-- Adjust path if necessary -->
    <style>
        /* Basic styles */
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
        }
        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        button {
            padding: 10px 15px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
        div,a{
       display: flex;
       justify-content: center;
       align-items: center;
       margin: 50px;
        }
    </style>
</head>
<body>
    <h1>Update User</h1>
    <form action="perform-update" method="post">
        <input type="hidden" name="userId" value="<%= request.getAttribute("user") != null ? ((User) request.getAttribute("user")).getId() : "" %>">

        <label for="username">Username:</label>
        <input type="text" id="username" name="username" value="<%= request.getAttribute("user") != null ? ((User) request.getAttribute("user")).getUsername() : "" %>" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" value="<%= request.getAttribute("user") != null ? ((User) request.getAttribute("user")).getPassword() : "" %>" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%= request.getAttribute("user") != null ? ((User) request.getAttribute("user")).getEmail() : "" %>" required>

        <button type="submit">Update User</button>
    </form>
     <div >
    <a href="manageUsers.jsp">Back to Manage Users</a>
            <a href="home.jsp">Back to Home</a>
    </div>
</body>
</html>
