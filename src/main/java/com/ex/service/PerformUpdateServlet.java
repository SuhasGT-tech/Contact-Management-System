package com.ex.service;

import com.ex.dao.UserDAO;
import com.ex.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/perform-update")
public class PerformUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userIdStr = req.getParameter("userId");
        if (userIdStr == null || userIdStr.isEmpty()) {
            req.setAttribute("error", "User ID is missing.");
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
            return;
        }

        long userId;
        try {
            userId = Long.parseLong(userIdStr);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Invalid User ID format.");
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.findById(userId);

        if (user != null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            userDAO.update(user);
            resp.sendRedirect("manage-users");
        } else {
            req.setAttribute("error", "User not found.");
            req.getRequestDispatcher("/updateUser.jsp").forward(req, resp);
        }
    }
}
