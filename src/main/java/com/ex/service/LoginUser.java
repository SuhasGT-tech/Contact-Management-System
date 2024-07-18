package com.ex.service;

import com.ex.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserService userService = UserService.getInstance();
        User user = userService.getUserByEmailAndPassword(email, password);

        if (user != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().removeAttribute("errorMessage");
            response.sendRedirect("home.jsp");
        } else {
            String errorMessage = "Invalid email or password.";
            request.getSession().setAttribute("errorMessage", errorMessage);
            System.out.println("Login failed: " + errorMessage); // Log the error
            response.sendRedirect("login.jsp");
        }
    }
}
