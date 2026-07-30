// BookstoreDriver.java -- the smallest interesting end-to-end run.

public class BookstoreDriver {

    public static void main(String[] args) {

        // Create list for items
        Bookstore cart = new Bookstore();

        // Add 3 items
        Book b1 = new Book("Inferno", 12.50, "Dante",   320);
        Magazine m1 = new Magazine("Wired", 6.99, 251);
        Book b2 = new Book("Dune",    15.00, "Herbert", 412);
        cart.addItem(b1);
        cart.addItem(m1);
        cart.addItem(b2);

        // Display all items in cart
        cart.listAll();

        // Display total price
        System.out.println("total: $" + cart.totalPrice());

        // try/catch finding "Wired" -> not found
        try {
            Item foundItem = cart.findByName("Wired");
            System.out.println("found: " + foundItem.summary());
        } catch (Exception e) {
            System.out.println("not found: " + e.getMessage());
        }

        // try/catch finding "Atlas" -> not found
        try {
            Item foundItem = cart.findByName("Atlas");
            System.out.println("found: " + foundItem);
        } catch (Exception e) {
            System.out.println("not found: " + e.getMessage());
        }
    }
}
