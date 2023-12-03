public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(int accountId, double overdraftLimit) {
        super(accountId);
        this.overdraftLimit = overdraftLimit;
    }

    public void overdraft(double amount) {
        if (amount <= overdraftLimit + getBalance()) {
            withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}
