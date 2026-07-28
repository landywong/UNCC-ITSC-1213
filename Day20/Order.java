// Order.java
//
// A customer's order: a list of MenuItems plus a method to compute
// the total price.

import java.util.ArrayList;

public class Order {

    private ArrayList<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    /** Add an item to the order. */
    public void addItem(MenuItem item) {
        this.items.add(item);
    }

    /** Return the sum of the prices of every item in the order. */
    public double total() {
        double total = 0.0;
        for (MenuItem item : this.items) {
            total += item.getPrice();
        }
        return total;
    }

    /** Print every item, then the total. */
    public void describe() {
        System.out.println("--- order ---");
        for (MenuItem item : this.items) {
            item.describe();
        }
        System.out.println("total: $" + this.total());
    }
}
