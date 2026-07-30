// Item.java -- abstract parent of every item the bookstore sells.
//
// Step 5 task: replace each numbered comment in the constructor with
// real Java. The getters and the abstract summary() method are
// already complete.

public abstract class Item {

    /** Item name. Visible to subclasses for use in summary(). */
    protected String name;

    /** Item price in dollars. */
    protected double price;

    public Item(String name, double price) {
        // Name validator
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        // Price validator
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        // 3. Assign this.name and this.price.
        this.name = name;
        this.price = price;
    }

    public String getName()  { return this.name;  }
    public double getPrice() { return this.price; }

    /** Return a one-line, human-readable summary of this item. */
    public abstract String summary();
}
