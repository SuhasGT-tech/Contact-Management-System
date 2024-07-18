<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete User</title>
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
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        button {
            padding: 10px 15px;
            color: white;
            background-color: #dc3545;
            border: none;
            border-radius: 5px;
        }
        button:hover {
            background-color: #c82333;
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
    <h1>Delete User</h1>
    <form action="deleteUserServlet" method="get">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required>

        <button type="submit">Delete User</button>
    </form>
    <div >
    <a href="manageUsers.jsp">Back to Manage Users</a>
            <a href="home.jsp">Back to Home</a>
    </div>
        
        
    
</body>
</html>
