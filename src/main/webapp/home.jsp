<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        nav {
            background-color: #333;
            color: white;
            padding: 10px 20px; /* Added padding for better spacing */
            display: flex; /* Use flexbox for alignment */
            align-items: center;
            justify-content: space-between; /* Space out the title and links */
        }

        .nav-title {
            font-size: 24px;
            font-weight: bold;
            color: white; /* Ensuring the text color is white */
        }

        .nav-title a {
            color: white; /* Ensure link text color is white */
            text-decoration: none;
        }

        nav ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            gap: 10px; /* Added gap between the links */
        }

        nav ul li {
            margin: 0;
        }

        nav ul li a {
            color: white;
            text-decoration: none;
        }

        .container {
            margin: 20px;
            text-align: center;
        }

        .crud-operations ul {
            list-style: none;
            padding: 0;
            display: flex;
            justify-content: center;
            gap: 20px;
        }

        .crud-operations ul li {
            margin: 5px 0;
        }

        .crud-operations ul li a {
            text-decoration: none;
            color: #333;
            padding: 10px 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            transition: background-color 0.3s;
        }

        .crud-operations ul li a:hover {
            background-color: #f4f4f4;
        }

        .info {
            margin-top: 20px;
        }

        .info a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <!-- Navigation bar -->
    <nav>
        <div class="nav-title">
            <a href="home.jsp">Contact Management System</a>
        </div>
        <ul>
            <c:choose>
                <c:when test="${empty sessionScope.user}">
                    <li><a href="register.jsp">Register</a></li>
                    <li><a href="login.jsp">Login</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="LogoutUser">Logout</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </nav>

    <div class="container">
        <c:choose>
            <c:when test="${not empty sessionScope.user}">
                <h2>Welcome back, ${sessionScope.user.username}!</h2>
                <div class="crud-operations">
                    <ul>
                        <li><a href="addContact.jsp">Add Contact</a></li>
                        <li><a href="viewContact.jsp">Manage Contacts</a></li>
                        <li><a href="manageUsers.jsp">Manage Profile</a></li>
                    </ul>
                </div>
            </c:when>
            <c:otherwise>
                <h2>Welcome to the Contact Management System</h2>
                <p>Please register or login to manage your contacts.</p>
                
                <div class="crud-operations">
                    <ul>
                        <li><a href="login.jsp?redirect=AddContact">Add Contact</a></li>
                        <li><a href="login.jsp?redirect=ViewContacts">Manage Contacts</a></li>
                        <li><a href="login.jsp?redirect=ManageProfile">Manage Profile</a></li>
                    </ul>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
