// Drink.java
//
// A drink the coffee shop sells. Extends MenuItem, adds a flag
// indicating whether the drink is iced.

public class Drink extends MenuItem {

    /** True if the drink is served iced; false for hot. */
    private boolean iced;

    public Drink(String name, double price, boolean iced) {
        super(name, price);
        this.iced = iced;
    }

    public boolean isIced() { return this.iced; }

    @Override
    public void describe() {
        String temperature = this.iced ? "iced" : "hot";
        System.out.println(
            "Drink: " + this.name + " (" + temperature
            + ", $" + this.price + ")");
    }
}
