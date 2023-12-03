public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountId, double interestRate) {
        super(accountId);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }
}
