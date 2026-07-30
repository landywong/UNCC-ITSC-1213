// Book.java -- a book the bookstore sells.

public class Book extends Item {

    private String author;
    private int    pages;

    public Book(String name, double price, String author, int pages) {
        super(name, price);
        // Author validator
        if (author == null || name.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be blank");
        }
        // Page validator
        if (pages < 0) {
            throw new IllegalArgumentException("Pages cannot be less than 0");
        }
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() { return this.author; }
    public int    getPages()  { return this.pages;  }

    @Override
    public String summary() {
        return "Book: " + this.name + " by " + this.author +
                " (" + this.pages + " pp, $" + this.price + ")";
    }
}
