public class Transaction {
    private int transactionId;
    private double amount;
    private String description;

    public Transaction(int transactionId, double amount, String description) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Amount: " + amount + ", Description: " + description;
    }
}
