// Magazine.java -- a magazine the bookstore sells.

public class Magazine extends Item {

    private int issueNumber;

    public Magazine(String name, double price, int issueNumber) {
        super(name, price);
        // Issue validator
        if (issueNumber < 0) {
            throw new IllegalArgumentException("Issue number cannot be negative");
        }
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() { return this.issueNumber; }

    @Override
    public String summary() {
        return "Magazine: " + this.name + " (issue #"
            + this.issueNumber + ", $" + this.price + ")";
    }
}
