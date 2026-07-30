// Bookstore.java -- the inventory of items, with a few common
// operations.

import java.util.ArrayList;

public class Bookstore {

    private ArrayList<Item> items;

    public Bookstore() {
        this.items = new ArrayList<>();
    }

    /** Append item to the inventory. */
    public void addItem(Item item) {
        items.add(item);
    }

    /** Return the sum of every item's price. 0.0 for an empty store. */
    public double totalPrice() {
        double total = 0.0;
        for (Item x : items) {
            total += x.getPrice();
        }
        return total;
    }

    /** Print summary() of every item, in insertion order. */
    public void listAll() {
        for (Item x : items) {
            System.out.println(x.summary());
        }
    }

    /**
     * Find an item by exact name match.
     *
     * @param name the name to look up.
     * @return the first Item whose getName().equals(name).
     * @throws ItemNotFoundException if no matching item exists.
     */
    public Item findByName(String name) throws ItemNotFoundException {
        for (Item it : items) {
            if (it.getName().equals(name)) {
                return it;
            }
        }
        throw new ItemNotFoundException("no item named '" +
                name + "' in bookstore");
    }

    /** Return the number of items in stock. */
    public int size() {
        return items.size();
    }
}
