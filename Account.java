public class Account {
    private int accountId;
    private double balance;

    public Account(int accountId) {
        this.accountId = accountId;
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
