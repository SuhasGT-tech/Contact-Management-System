<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: black;
            color: #fff;
            width: 100%;
            padding: 10px 20px;
            box-sizing: border-box;
            text-align: center;
            margin-bottom: 20px;
        }
        .header a {
            color: #fff;
            text-decoration: none;
            font-size: 18px;
        }

        .login-container {
            max-width: 300px;
            margin: 100px auto;
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

        input {
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
 <div class="header">
        <a href="home.jsp">Contact Management System</a>
    </div>
    <div class="login-container">
        <h2>Login</h2>
        <%-- Display error message if login fails --%>
        <c:if test="${not empty sessionScope.errorMessage}">
            <p class="error"><c:out value="${sessionScope.errorMessage}"/></p>
        </c:if>
        <form action="LoginUser" method="post">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>
            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>
            <button type="submit">Login</button>
        </form>
        <p><a href="register.jsp">New User? Register Here</a></p>
                <p><a href="home.jsp">Back To Home</a></p>
        
    </div>
</body>
</html>
