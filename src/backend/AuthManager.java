package backend;

import Splashscreen.LoadingSplash;
import cinematrix.MainFrame;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;

public class AuthManager {

    Database db = new Database();
    Session session = new Session();

    // Sign up method
    public void signup(String firstName, String lastName, LocalDate birthDate, int age, String username, String password) {
        String UID = generateUserID();

        UserTemplate newUser = new UserTemplate(UID, firstName, lastName, age, username, password, birthDate);
        db.addUserToDB(newUser);
        System.out.println("Sign up successful!");
    }

    // Login method
    public void login(String username, String password) {
        List<UserTemplate> users = db.getUsers();
        for (UserTemplate user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

                session = new Session(user.getUsername(), user.getUID());
                LoadingSplash ls = new LoadingSplash(session);
                ls.setVisible(true);
               
                System.out.println("User Found: " + user.getUsername());
                return;
            }
        }
        System.out.println("User Not Found!");

    }
    public String generateUserID() {
        String userID;
        do {
            // Generate a random UUID (Universally Unique Identifier)
            // and return the first 6 characters of its string representation
            userID = UUID.randomUUID().toString().substring(0, 6);
        } while (db.isUserIDExists(userID)); // Check if the generated ID already exists in the database
        return userID;
    }

}
