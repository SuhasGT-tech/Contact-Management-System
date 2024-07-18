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

@WebServlet("/AddContact")
public class AddContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        Contact contact = new Contact();
        contact.setUsername(name);  // Save the name as username
        contact.setPhone(phone);
        contact.setEmail(email);
        contact.setUser(user);

        ContactService contactService = ContactService.getInstance();
        try {
            contactService.addContact(contact);
            response.sendRedirect("ViewContacts");  // Redirect to ViewContacts to see the new contact
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error adding contact.");
            request.getRequestDispatcher("addContact.jsp").forward(request, response);
        }
    }
}
