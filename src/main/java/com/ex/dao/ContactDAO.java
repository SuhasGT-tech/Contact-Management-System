package com.ex.dao;

import com.ex.entity.Contact;
import com.ex.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ContactDAO {

    // Fetch all contacts
    public List<Contact> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contact> contactList = null;
        try {
            contactList = session.createQuery("FROM Contact", Contact.class).list();
        } finally {
            session.close();
        }
        return contactList;
    }

    // Save a new Contact
    public void save(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(contact);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Find a Contact by ID
    public Contact findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Contact contact = null;
        try {
            contact = session.get(Contact.class, id);
        } finally {
            session.close();
        }
        return contact;
    }

    // Delete a Contact
    public void delete(Long contactId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(contactId);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    // Update an existing Contact
    public void update(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(contact);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Contact> findContactsByUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Contact> contactList = null;
        try {
            String hql = "FROM Contact WHERE user = :user";
            Query<Contact> query = session.createQuery(hql, Contact.class);
            query.setParameter("user", user);
            contactList = query.list();
            System.out.println("Retrieved contacts: " + contactList.size()); // Log number of contacts
        } finally {
            session.close();
        }
        return contactList;
    }

}
