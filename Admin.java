import java.util.List;

public class Admin extends User {
    public Admin(int userId, String username, String password) {
        super(userId, username, password);
    }

    public void viewAllUsers(List<User> users) {
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + ", Username: " + user.getUsername());
        }
    }

    // Additional methods...
}
