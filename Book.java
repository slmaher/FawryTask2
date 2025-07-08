// book in the Quantum Bookstore
public abstract class Book {
    private final String isbn;
    private final String title;
    private final String author;
    private final int yearPublished;
    private double price;

    public Book(String isbn, String title, String author, int yearPublished, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Indicates if the book can be purchased
    public abstract boolean isForSale();
} 