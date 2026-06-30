/**
 * The Transaction interface defines basic banking operations.
 * 
 * @author ITSC 1213
 * @version Mar 9, 2025
 */
 
public interface Transaction {
    /**
     * Deposits a specified amount into the account.
     *
     * @param amount the amount to deposit, must be positive
     */
    void deposit(double amount);

    /**
     * Withdraws a specified amount from the account.
     *
     * @param amount the amount to withdraw, must not exceed available balance
     */
    void withdraw(double amount);
}

