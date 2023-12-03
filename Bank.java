import java.util.List;

public class Bank {
    private List<User> users;
    private List<Transaction> transactions;
    private User currentUser;

    public Bank() {
        this.users = new java.util.ArrayList<>();
        this.transactions = new java.util.ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                return true;
            }
        }
        return false;
    }

    public void storeMoney(double amount, String description) {
        int transactionId = transactions.size() + 1;
        Transaction transaction = new Transaction(transactionId, amount, description);
        transactions.add(transaction);
        currentUser.getTransactions().add(transaction);
    }

    // public void transferMoney(double amount, String description, User recipient) {
    //     if (users.contains(currentUser) && users.contains(recipient)) {
    //         storeMoney(-amount, "Transfer to " + recipient.getUsername() + ": " + description);
    //         recipient.getTransactions().add(new Transaction(transactions.size() + 1, amount, "Received from " + currentUser.getUsername() + ": " + description));
    //     }
    // }

    public void depositMoney(double amount, String description) {
        storeMoney(amount, description);
    }

    public void withdrawMoney(double amount, String description) {
        if (amount <= currentUser.getAccount().getBalance()) {
            storeMoney(-amount, description);
        } else {
            System.out.println("Insufficient funds for withdrawal.");
        }
    }

    public void transferMoney(double amount, String description, User recipient) {
        if (currentUser.getAccount().getBalance() >= amount) {
            storeMoney(-amount, "Transfer to " + recipient.getUsername() + ": " + description);
            recipient.storeMoney(amount, "Received from " + currentUser.getUsername() + ": " + description);
        } else {
            System.out.println("Insufficient funds for transfer.");
        }
    }

    public void addUser(String username, String password) {
        User newUser = new User(users.size() + 1, username, password);
        users.add(newUser);
        System.out.println("User added successfully.");
    }

    public void viewAllInfo(User selectedUser) {
        if (currentUser instanceof Admin) {
            System.out.println("User ID: " + selectedUser.getUserId() + ", Username: " + selectedUser.getUsername());
            // ... (tampilkan informasi lainnya)
        } else {
            System.out.println("Access denied. Only admin can view all user info.");
        }
    }
}
