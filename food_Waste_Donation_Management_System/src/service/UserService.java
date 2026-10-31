package service;

import java.util.ArrayList;
import model.User;

public class UserService {

    private ArrayList<User> users = new ArrayList<>();

    // Register a new user
    public void registerUser(User user) {

        // Check whether email already exists
        for (User existingUser : users) {

            if (existingUser.getEmail().equals(user.getEmail())) {
                System.out.println("Email already registered!");
                return;
            }
        }

        users.add(user);
        System.out.println("User registered successfully!");
    }

    // Login user
    public User loginUser(String email, String password) {

        for (User user : users) {

            if (user.getEmail().equals(email) &&
                user.getPassword().equals(password)) {

                return user;
            }
        }

        return null;
    }
}