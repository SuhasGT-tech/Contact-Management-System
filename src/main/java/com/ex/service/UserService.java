package com.ex.service;

import com.ex.dao.UserDAO;
import com.ex.entity.User;

import java.util.List;

public class UserService {
    private static UserService instance;  // Singleton instance
    private UserDAO userDAO;

    private UserService() {
        userDAO = new UserDAO();  // Initialize UserDAO instance
    }

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public void createUser(User user) {
        userDAO.save(user);  // Use the save method
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return userDAO.findByEmailAndPassword(email, password);
        
    }
    public void deleteUser(User user) {
        userDAO.delete(user);  
    }

    public List<User> getAllUsers() {
        return userDAO.findAllUsers();
    }
    public User getUserById(long id) {
		return userDAO.findById(null);
    	
    }
    public void updateUser(User user) {
        userDAO.update(user);  
    }
}
