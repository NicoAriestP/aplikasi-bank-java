import java.time.LocalDateTime;

public class TransactionRecord {
    private LocalDateTime timestamp;
    private TransactionType transactionType;
    private double amount;
    private String description;

    public TransactionRecord(TransactionType transactionType, double amount, String description) {
        this.timestamp = LocalDateTime.now();
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + transactionType + ": " + amount + ", Description: " + description;
    }
}
