package com.ex.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteContact")
public class DeleteContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            try {
                Long contactId = Long.parseLong(id);
                ContactService contactService = ContactService.getInstance();
                contactService.deleteContact(contactId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("ViewContacts");
    }
}
