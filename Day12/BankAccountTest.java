/**
 * Simple test class for the BankAccount class.
 * Uses basic conditionals to check expected vs. actual values with formatted
 * output.
 * 
 * @author ITSC 1213
 * @version Mar 9, 2025
 */

public class BankAccountTest {
    public static void main(String[] args) {
        testImplementsTransaction();
        testConstructor();
        testConstructorNegativeBalance();
        testDeposit();
        testWithdraw();
        testWithdrawInsufficientFunds();
        testDepositNegative();
        testWithdrawNegative();
    }

    /**
     * Tests that BankAccount implements the Transaction interface.
     */
    public static void testImplementsTransaction() {
        BankAccount account = new BankAccount(100.0);
        if (account instanceof Transaction) {
            System.out.println(
                    "++++ PASS --> testImplementsTransaction: BankAccount correctly implements Transaction interface.");
        } else {
            System.out.println(
                    "---- FAIL --> testImplementsTransaction: FAIL (BankAccount does not implement Transaction).");
        }
    }

    /**
     * Tests the constructor and initial balance.
     */
    public static void testConstructor() {
        BankAccount account = new BankAccount(100.0);
        if (account.getBalance() == 100.0) {
            System.out.println("++++ PASS --> testConstructor: Initial balance set correctly.");
        } else {
            System.out.println(
                    "---- FAIL --> testConstructor: FAIL (Expected: 100.0, Got: " + account.getBalance() + ")");
        }
    }

    /**
     * Tests that the constructor throws an exception for a negative initial
     * deposit.
     */
    public static void testConstructorNegativeBalance() {
        try {
            new BankAccount(-50.0);
            System.out.println(
                    "---- FAIL --> testConstructorNegativeBalance: FAIL (Expected exception, but object created)");
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "++++ PASS --> testConstructorNegativeBalance: Correctly threw exception for negative initial balance.");
        }
    }

    /**
     * Tests a valid deposit.
     */
    public static void testDeposit() {
        BankAccount account = new BankAccount(100.0);
        account.deposit(50.0);
        if (account.getBalance() == 150.0) {
            System.out.println("++++ PASS --> testDeposit: Balance increased correctly after deposit.");
        } else {
            System.out.println("---- FAIL --> testDeposit: FAIL (Expected: 150.0, Got: " + account.getBalance() + ")");
        }
    }

    /**
     * Tests a valid withdrawal.
     */
    public static void testWithdraw() {
        BankAccount account = new BankAccount(100.0);
        account.withdraw(40.0);
        if (account.getBalance() == 60.0) {
            System.out.println("++++ PASS --> testWithdraw: Balance decreased correctly after withdrawal.");
        } else {
            System.out.println("---- FAIL --> testWithdraw: FAIL (Expected: 60.0, Got: " + account.getBalance() + ")");
        }
    }

    /**
     * Tests withdrawal when balance is insufficient.
     */
    public static void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(100.0);
        try {
            account.withdraw(200.0);
            System.out.println(
                    "---- FAIL --> testWithdrawInsufficientFunds: FAIL (Expected exception, but withdrawal succeeded)");
        } catch (IllegalArgumentException e) {
            System.out.println(
                    "++++ PASS --> testWithdrawInsufficientFunds: Correctly threw exception for insufficient funds.");
        }
    }

    /**
     * Tests deposit with a negative amount.
     */
    public static void testDepositNegative() {
        BankAccount account = new BankAccount(100.0);
        try {
            account.deposit(-20.0);
            System.out.println("---- FAIL --> testDepositNegative: FAIL (Expected exception, but deposit succeeded)");
        } catch (IllegalArgumentException e) {
            System.out.println("++++ PASS --> testDepositNegative: Correctly threw exception for negative deposit.");
        }
    }

    /**
     * Tests withdrawal with a negative amount.
     */
    public static void testWithdrawNegative() {
        BankAccount account = new BankAccount(100.0);
        try {
            account.withdraw(-10.0);
            System.out
                    .println("---- FAIL --> testWithdrawNegative: FAIL (Expected exception, but withdrawal succeeded)");
        } catch (IllegalArgumentException e) {
            System.out
                    .println("++++ PASS --> testWithdrawNegative: Correctly threw exception for negative withdrawal.");
        }
    }
}
