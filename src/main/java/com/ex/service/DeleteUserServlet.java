package com.ex.service;

import com.ex.entity.User;
import com.ex.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        UserService userService = UserService.getInstance();
        try {
            userService.deleteUser(user);  // Pass the User object
            session.invalidate(); // Invalidate the session
            response.sendRedirect("home.jsp?message=Account%20deleted%20successfully");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error deleting account.");
            request.getRequestDispatcher("manageUsers.jsp").forward(request, response);
        }
    }
}
