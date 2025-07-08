// Physical book with stock management
public class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, String author, int yearPublished, double price, int stock) {
        super(isbn, title, author, yearPublished, price);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    // Reduces stock by the specified quantity
    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        stock -= quantity;
    }

    @Override
    public boolean isForSale() {
        return true;
    }
} 