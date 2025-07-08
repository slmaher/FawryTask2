import java.util.*;

// Main inventory and sales logic for Quantum Bookstore
public class QuantumBookstore {
    private final Map<String, Book> inventory = new HashMap<>();

    // adds a book to the inventory
    public void addBook(Book book) {
        inventory.put(book.getIsbn(), book);
        System.out.println("Quantum Bookstore: Added book '" + book.getTitle() + "' (ISBN: " + book.getIsbn() + ")");
    }

    // Removes and returns books older than the given number of years
    public List<Book> removeBooksOlderThan(int years) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        List<Book> removed = new ArrayList<>();
        Iterator<Map.Entry<String, Book>> it = inventory.entrySet().iterator();
        while (it.hasNext()) {
            Book book = it.next().getValue();
            if (currentYear - book.getYearPublished() > years) {
                removed.add(book);
                it.remove();
                System.out.println("Quantum Bookstore: Removed book '" + book.getTitle() + "' (ISBN: " + book.getIsbn() + ")");
            }
        }
        return removed;
    }

    // Processes a book purchase
    public double buyBook(String isbn, int quantity, String email, String address) throws BookNotAvailableException {
        Book book = inventory.get(isbn);
        if (book == null || !book.isForSale()) {
            throw new BookNotAvailableException("Quantum Bookstore: Book not available for sale (ISBN: " + isbn + ")");
        }

        double subtotal = book.getPrice() * quantity;
        double shipping = 0.0;

        if (book instanceof PaperBook paperBook) {
            if (paperBook.getStock() < quantity) {
                throw new BookNotAvailableException("Quantum Bookstore: Not enough stock for PaperBook (ISBN: " + isbn + ")");
            }
            paperBook.reduceStock(quantity);
            shipping = 10.00; // flat shipping for paper books

            // Shipment Notice
            System.out.println("** Shipment notice **");
            System.out.printf("%dx %s\n", quantity, paperBook.getTitle());
            System.out.println("Address: " + address);
            System.out.println();
            ShippingService.ship(paperBook, address, quantity);

        } else if (book instanceof EBook ebook) {
            // No shipping fee for eBooks
            System.out.println("** Sending eBook **");
            System.out.printf("%dx %s [%s] to %s\n", quantity, ebook.getTitle(), ebook.getFileType(), email);
            System.out.println();
            MailService.send(ebook, email, quantity);
        }

        double total = subtotal + shipping;

        // Checkout receipt
        System.out.println("** Checkout receipt **");
        System.out.printf("%dx %s @ $%.2f\n", quantity, book.getTitle(), book.getPrice());
        System.out.println("--------------------------");
        System.out.printf("Subtotal: $%.2f\n", subtotal);
        if (shipping > 0) {
            System.out.printf("Shipping: $%.2f\n", shipping);
        }
        System.out.printf("Total: $%.2f\n", total);
        System.out.println();

        return total;
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public int getInventorySize() {
        return inventory.size();
    }
}
