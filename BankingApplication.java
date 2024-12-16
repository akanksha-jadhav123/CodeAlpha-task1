import java.util.Scanner;

public class BankingApplication {

    // Declare the balance
    private static double balance = 0.0;

    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Main loop to display the menu and process user's choice
        do {
            // Displaying the menu
            System.out.println("\n*** Welcome to Your Bank ***");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            // Read the user's choice
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(scanner);  // Call deposit method
                    break;
                case 2:
                    withdraw(scanner);  // Call withdraw method
                    break;
                case 3:
                    checkBalance();  // Call check balance method
                    break;
                case 4:
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);  // Continue until user chooses to exit

        scanner.close();
    }

    // Method to handle deposit
    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " successfully.");
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Method to handle withdrawal
    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " successfully.");
            } else {
                System.out.println("Insufficient balance. Your balance is $" + balance);
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Method to check balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
}
