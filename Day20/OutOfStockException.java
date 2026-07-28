// OutOfStockException.java
//
// Raised when an Order asks the Inventory for an item that is not in
// stock. Checked: extends Exception (not RuntimeException), so callers
// must either catch it or declare it.

public class OutOfStockException extends Exception {

    public OutOfStockException(String message) {
        super(message);
    }
}
