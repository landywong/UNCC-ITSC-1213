// CoffeeShop.java
//
// Driver. Builds an inventory, takes a customer's order, and prints
// the receipt. The body of main demonstrates several debugging
// scenarios: a typical happy-path order, an attempt to look up an
// item that is in stock but typed slightly differently, an attempt to
// look up an item that is not in stock, and a corrupt MenuItem
// (negative price) that the missing constructor validation lets
// through.

public class CoffeeShop {

    public static void main(String[] args) {

        // ----- Build the inventory ------------------------------
        Inventory<MenuItem> inventory = new Inventory<>();
        inventory.add(new Drink("espresso",   3.50, false));
        inventory.add(new Drink("cold brew",  4.50, true));
        inventory.add(new Pastry("croissant", 3.00, true));
        inventory.add(new Pastry("macaron",   2.00, false));

        try {
            inventory.add(new Drink("free latte", -1.00, false));
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println("Invalid menu item: " + e.getMessage());
        }

        // ----- Build a customer's order -------------------------
        Order order = new Order();

        // Look up by name and add to the order. We need a try/catch
        // because lookup throws a checked exception.
        try {
            order.addItem(inventory.lookup("espresso"));
            order.addItem(inventory.lookup("croissant"));
        } catch (OutOfStockException e) {
            System.out.println("could not build order: " + e.getMessage());
        }

        // ----- Print the receipt --------------------------------
        order.describe();

        // ----- Demonstrate the lookup paths ---------------------

        // (a) An item that really IS in the inventory, looked up via
        // a dynamically-constructed String (not from the constant
        // pool). Because of BUG #4 (== for strings), reference
        // comparison fails to find the match even though the
        // characters are identical.
        String wanted = new String("espresso");
        try {
            MenuItem found = inventory.lookup(wanted);
            System.out.println("found: " + found.getName());
        } catch (OutOfStockException e) {
            System.out.println("lookup miss: " + e.getMessage());
        }

        // (b) An item that really is not in stock. Because of BUG #3
        // (off-by-one in lookup's loop bound), the missing item
        // throws IndexOutOfBoundsException before lookup gets the
        // chance to throw OutOfStockException. Note also BUG #6: we
        // catch the wrong exception type below.
        try {
            inventory.lookup("matcha latte");
        } catch (OutOfStockException | IndexOutOfBoundsException e) {
            System.out.println("lookup miss: " + e.getMessage());
        }

        System.out.println("--- end of run ---");
    }
}
