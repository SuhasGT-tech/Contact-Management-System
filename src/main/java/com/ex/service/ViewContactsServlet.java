package com.ex.service;

import com.ex.entity.Contact;
import com.ex.entity.User;
import com.ex.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewContacts")
public class ViewContactsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        ContactService contactService = ContactService.getInstance();
        List<Contact> contacts = contactService.getContactsByUser(user);

        request.setAttribute("contactList", contacts);  // Ensure that this name matches in JSP
        request.getRequestDispatcher("viewContact.jsp").forward(request, response);
    }
}
