// Inventory.java
//
// Generic inventory of MenuItem subclasses. Holds a list of items in
// insertion order. lookup(name) returns the first item whose name
// matches, or throws OutOfStockException if no match exists.

import java.util.ArrayList;

public class Inventory<T extends MenuItem> {

    private ArrayList<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    /** Add an item to the inventory. */
    public void add(T item) {
        this.items.add(item);
    }

    /**
     * Find an item by exact name match.
     *
     * @param name the name to look up.
     * @return the first item whose name equals the given name.
     * @throws OutOfStockException if no matching item exists.
     */
    public T lookup(String name) throws OutOfStockException {
        for (int i = 0; i < this.items.size(); i++) {

            T item = this.items.get(i);

            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new OutOfStockException(
            "no item named '" + name + "' in inventory");
    }

    /** Return the number of items in the inventory. */
    public int size() {
        return this.items.size();
    }
}
