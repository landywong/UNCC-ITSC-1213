// ItemNotFoundException.java -- raised when Bookstore.findByName
// cannot locate the requested item.
//
// Checked: extends Exception (not RuntimeException), so callers must
// either catch it or declare it on their own throws clause.

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(String message) {
        super(message);
    }
}
