import java.util.ArrayList;

class Dessert {
    protected String flavor;
    protected int servings;
    protected static int count = 0;

    public Dessert(String flavor, int servings) {
        this.flavor = flavor;
        this.servings = servings;
        count++;
    }

    public int cost() {
        return servings * 3;
    }

    public String label() {
        return flavor.toUpperCase();
    }
}

class Sundae extends Dessert {
    private String topping;

    public Sundae(String flavor, int servings, String topping) {
        this.topping = topping;
        super(flavor, servings);
    }

    @Override
    public int cost() {
        return super.cost() + topping.length() * 2;
    }
}

class Milkshake extends Dessert {
    private int sizeOz;

    public Milkshake(String flavor, int servings, int sizeOz) {
        super(flavor, servings);
        this.sizeOz = sizeOz;
    }

    @Override
    public int cost() {
        return super.cost() + sizeOz;
    }
}

public class Main {
    static final int SECRET = 13;

    public static void main(String[] args) {
        ArrayList<Dessert> menu = new ArrayList<>();
        menu.add(new Sundae("vanilla", 2, "fudge"));
        menu.add(new Milkshake("chocolate", 1, 16));
        menu.add(new Sundae("strawberry", 3, "nuts"));
        menu.add(new Dessert("mango", 4));
        menu.add(0, new Milkshake("BANANA", 2, 12));

        int total = 0;
        for (Dessert d : menu) {
            total += d.cost();
        }

        ArrayList<Integer> lengths = new ArrayList<>();
        for (Dessert d : menu) {
            lengths.add(d.label().length());
        }
        int sumLen = 0;
        for (int x : lengths) {
            sumLen += x;
        }

        String head = menu.get(0).label();
        int idx = head.indexOf("A");
        int ch = head.charAt(0);

        int bonus = 0;
        if (head.equals("BANANA")) {
            bonus = 50;
        }

        int result = total * SECRET + Dessert.count * 100 + sumLen + idx + ch + bonus;
        System.out.println(result);
    }
}