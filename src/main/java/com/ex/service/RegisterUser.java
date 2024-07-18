package com.ex.service;

import com.ex.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (username != null && password != null && email != null) {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);

            // Call UserService to save the new user
            UserService userService = UserService.getInstance();
            userService.createUser(user);

            response.sendRedirect("login.jsp");  // Redirect to the login page after successful registration
        } else {
            response.sendRedirect("register.jsp");  // Redirect to the registration page if any field is missing
        }
    }
}
