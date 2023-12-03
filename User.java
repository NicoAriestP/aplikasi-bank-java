import java.util.List;

public class User {
    private int userId;
    private String username;
    private String password;
    private List<Transaction> transactions;
    private Account account;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.transactions = new java.util.ArrayList<>();
    }

    public Account getAccount() {
        return account;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void viewTransactionHistory() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void viewPersonalInfo() {
        System.out.println("User ID: " + getUserId() + ", Username: " + getUsername());
        // ... (tampilkan informasi lainnya)
        System.out.println("Transaction History:");
        viewTransactionHistory();
    }

    public void storeMoney(double amount, String description) {
        int transactionId = transactions.size() + 1;
        Transaction transaction = new Transaction(transactionId, amount, description);
        transactions.add(transaction);
        account.deposit(amount);
    }
}
