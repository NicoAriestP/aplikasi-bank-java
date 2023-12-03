import java.util.Scanner;

public class BookKeepingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek Bank
        Bank bank = new Bank();

        // Membuat beberapa objek User
        User user1 = new User(1, "user1", "password1");
        User user2 = new User(2, "user2", "password2");
        Admin admin = new Admin(0, "admin", "adminpassword");

        // Menambahkan user ke bank
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addUser(admin);

        // Autentikasi user
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (bank.authenticateUser(username, password)) {
            System.out.println("Welcome, " + bank.getCurrentUser().getUsername() + "!");
            bank.storeMoney(1000, "Initial deposit");
            bank.getCurrentUser().viewTransactionHistory();

        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }
}
