// MenuItem.java
//
// Abstract parent of every item the coffee shop sells. A MenuItem has a
// name and a price. Concrete subclasses (Drink, Pastry) override
// describe() to print themselves nicely.

public abstract class MenuItem {

    /** Item name (e.g., "espresso"). */
    protected String name;

    /** Item price in dollars. */
    protected double price;

    public MenuItem(String name, double price) {
        if (name == null) {
            throw new NullPointerException("name cannot be null");
        }
        if (price < 0) {
            throw new IllegalArgumentException("price must be non-negative: " + price);
        }
        this.name = name;
        this.price = price;
    }

    public String getName()  { return this.name;  }
    public double getPrice() { return this.price; }

    /** Print a one-line description of this menu item. */
    public abstract void describe();
}
