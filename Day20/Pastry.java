// Pastry.java
//
// A pastry the coffee shop sells. Extends MenuItem, adds a flag
// indicating whether the pastry contains gluten.

public class Pastry extends MenuItem {

    /** True if the pastry contains gluten; false otherwise. */
    private boolean containsGluten;

    public Pastry(String name, double price, boolean containsGluten) {
        super(name, price);
        this.containsGluten = containsGluten;
    }

    public boolean containsGluten() { return this.containsGluten; }

    @Override
    public void describe() {
        String diet = this.containsGluten ? "contains gluten" : "gluten-free";
        System.out.println(
            "Pastry: " + this.name + " (" + diet
            + ", $" + this.price + ")");
    }
}
