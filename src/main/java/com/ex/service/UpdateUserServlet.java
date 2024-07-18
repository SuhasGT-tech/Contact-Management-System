package com.ex.service;

import com.ex.entity.User;
import com.ex.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");

        if (userIdStr == null || userIdStr.isEmpty()) {
            resp.sendRedirect("manage-users"); // Redirect if userId is not present
            return;
        }

        long userId;
        try {
            userId = Long.parseLong(userIdStr);
        } catch (NumberFormatException e) {
            resp.sendRedirect("manage-users"); // Redirect if userId is not a valid number
            return;
        }

        UserService userService = UserService.getInstance();
        User user = userService.getUserById(userId); // Method to fetch user by ID

        if (user != null) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp); // Forward to JSP
        } else {
            resp.sendRedirect("manage-users"); // Redirect if user is not found
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        if (userIdStr == null || username == null || password == null || email == null) {
            resp.sendRedirect("manage-users"); 
            return;
        }

        long userId;
        try {
            userId = Long.parseLong(userIdStr);
        } catch (NumberFormatException e) {
            resp.sendRedirect("manage-users"); 
            return;
        }

        UserService userService = UserService.getInstance();
        User user = new User();
        user.setId(userId);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        userService.updateUser(user);
        resp.sendRedirect("manage-users"); 
    }
}
