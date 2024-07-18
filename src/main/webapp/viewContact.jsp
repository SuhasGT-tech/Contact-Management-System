<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Contacts</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .actions a {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Contact List</h2>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="contact" items="${contactList}">  <!-- Corrected from "contacts" to "contactList" -->
                    <tr>
                        <td>${contact.username}</td>
                        <td>${contact.phone}</td>
                        <td>${contact.email}</td>
                        <td class="actions">
                            <a href="UpdateContact?id=${contact.id}">Update</a>
                            <a href="DeleteContact?id=${contact.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
            <p><a href="home.jsp">Back to Home Page</a></p>
    
</body>
</html>
