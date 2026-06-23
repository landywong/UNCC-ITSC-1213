// Create a program featuring 2 classes, 4 methods, private & final fields
/* An icecream shop that measures the following
    final field that contains the name of shop
    private fields of the flavors
 */
public class CodeACode{
    public static void main(String[] args) {
        // Final field
        final String shop = "Wong's Ice Creamery";
        System.out.println("Welcome to " + shop + "!");
        System.out.println();

        // Ice cream orders
        Icecream customer1 = new Icecream("Vanilla", 2, true);
        Icecream customer2 = new Icecream("Strawberry", 1, true);
        Icecream customer3 = new Icecream("Chocolate", 3, false);
        System.out.println("Customer 1 ordered:");
        customer1.details();
        System.out.println("Customer 2 ordered:");
        customer2.details();
        System.out.println("Customer 3 ordered:");
        customer3.details();

        // Total revenue from shop
        Money register = new Money();
        register.addOrder(customer1);
        register.addOrder(customer2);
        register.addOrder(customer3);
        double money = register.getTotal();
        System.out.println();
        System.out.println("Total revenue for the day: $" + money);
    }
}

class Icecream {
    // examples of Icecream fuctions from Day 4
    // Private fields
    private String flavor;
    private int scoopCount;
    private boolean cone;

    public Icecream(String flav, int scpCount, boolean cone) {
        this.flavor = flav;
        this.scoopCount = scpCount;
        this.cone = cone;
    }

    // GETTER FOR FLAVOR
    public String getFlavor() {
        return this.flavor;
    }

    // GETTER FOR SCOOPCOUNT
    public int getScoopCount() {
        return this.scoopCount;
    }

    // GETTER FOR CONE
    public boolean isCone() {
        return this.cone;
    }

    // SETTER FOR FLAVOR
    public void setFlavor(String flav) {
        this.flavor = flav;
    }

    // SETTER FOR SCOOPCOUNT
    public void setScoopCount(int cnt) {
        this.scoopCount = cnt;
    }

    // SETTER FOR CONE
    public void setCone(boolean cone) {
        this.cone = cone;
    }

    // METHOD TO DISPLAY THE ICECREAM DETAILS
    public void details() {
        System.out.println(this.flavor + " icecream with "
                + this.scoopCount + " scoops");
        if (cone) {
            System.out.println("on a cone.");
        } else {
            System.out.println("in a cup.");
        }
    }
}

class Money {
    // Second class for calculating Icecream cost
    private double total = 0;
    /* Prices for Icecream
        Vanilla per scoop = $2
        Chocolate per scoop = $3
        Strawberry per scoop = $3
        Cone = $0.25
     */

    // Getter for Icecream order
    public void addOrder(Icecream order) {
        String flavor = order.getFlavor();
        int scoops = order.getScoopCount();
        boolean cone = order.isCone();

        // Calculates the price of the scoops
        double pricePerScoop = 0;
        if (flavor.equalsIgnoreCase("Vanilla")) {
            pricePerScoop = 2.00;
        } else if (flavor.equalsIgnoreCase("Chocolate") || flavor.equalsIgnoreCase("Strawberry")) {
            pricePerScoop = 3.00;
        }

        total += pricePerScoop * scoops;

        // Adds the cost of Icecream cone if ordered
        if (cone) {
            total += 0.25;
        }
    }

    // Gets/returns total revenue made to main function
    public double getTotal() {
        return total;
    }
}

