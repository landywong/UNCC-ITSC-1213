/**
 * TODO Write a one-sentence summary of your class here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author  TODO Your Name
 * @version Mar 06, 2025
 */
import java.util.Scanner;

/**
 * The BankDemo class demonstrates the use of the BankAccount class.
 * It allows the user to perform basic banking transactions.
 * 
 * @author ITSC 1213
 * @version Mar 9, 2025
 */
public class BankDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();

            // Create an instance of BankAccount 
            // (Note that this will only work after you create the BankAccount class following the provided guidelines)
            BankAccount myAccount = new BankAccount(initialBalance);

            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            myAccount.deposit(depositAmount);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = scanner.nextDouble();
            myAccount.withdraw(withdrawAmount);

            System.out.println("Final Balance: $" + myAccount.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
        } finally {
            scanner.close();
        }
    }
}
