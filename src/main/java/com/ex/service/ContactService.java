package com.ex.service;

import com.ex.dao.ContactDAO;
import com.ex.entity.Contact;
import com.ex.entity.User;

import java.util.List;

public class ContactService {
    private static ContactService instance;  // Singleton instance
    private ContactDAO contactDAO;

    private ContactService() {
        contactDAO = new ContactDAO();  // Initialize ContactDAO instance
    }

    public static synchronized ContactService getInstance() {
        if (instance == null) {
            instance = new ContactService();
        }
        return instance;
    }

    public void addContact(Contact contact) {
        contactDAO.save(contact);  // Save a new contact
    }

    public List<Contact> getAllContacts() {
        return contactDAO.findAll();  // Fetch all contacts
    }

    public Contact getContactById(Long id) {
        return contactDAO.findById(id);  // Find a contact by ID
    }

    public void updateContact(Contact contact) {
        contactDAO.update(contact);  // Update an existing contact
    }

    public void deleteContact(Long contactId) {
        contactDAO.delete(contactId);  // Delete a contact
    }

    public List<Contact> getContactsByUser(User user) {
        List<Contact> contacts = contactDAO.findContactsByUser(user);
        System.out.println("Service: Retrieved contacts for user " + user.getUsername() + ": " + contacts.size());
        return contacts;
    }
}
