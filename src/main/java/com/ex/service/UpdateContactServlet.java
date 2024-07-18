package com.ex.service;

import com.ex.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateContact")
public class UpdateContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            try {
                Long contactId = Long.parseLong(id);
                ContactService contactService = ContactService.getInstance();
                Contact contact = contactService.getContactById(contactId);
                request.setAttribute("contact", contact);
                request.getRequestDispatcher("updateContact.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (id != null && !id.isEmpty() && username != null && email != null && phone != null) {
            try {
                Long contactId = Long.parseLong(id);
                ContactService contactService = ContactService.getInstance();
                Contact contact = contactService.getContactById(contactId);
                if (contact != null) {
                    contact.setUsername(username);
                    contact.setEmail(email);
                    contact.setPhone(phone);
                    contactService.updateContact(contact);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("ViewContacts");
    }
}
