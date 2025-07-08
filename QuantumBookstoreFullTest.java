public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        QuantumBookstore store = new QuantumBookstore();

        // Add books to inventory
        PaperBook pb1 = new PaperBook("1111", "Java basics", "Alice Smith", 2010, 39.99, 5);
        EBook eb1 = new EBook("2222", "Quantum computing", "Bob Jones", 2022, 19.99, "PDF");
        PaperBook pb2 = new PaperBook("4444", "bin El kassreen", "naguib mahfouz", 1956, 49.99, 3);
        PaperBook pb3 = new PaperBook("5555", "The Harafish", "naguib mahfouz", 1977, 59.99, 4);
        PaperBook pb4 = new PaperBook("6666", "The blue elephant", "Ahmed Mourad", 2012, 54.99, 6);
        PaperBook pb5 = new PaperBook("7777", "Stone and Sky", "Ben Aronavith", 1996, 44.99, 2);
        store.addBook(pb1);
        store.addBook(eb1);
        store.addBook(pb2);
        store.addBook(pb3);
        store.addBook(pb4);
        store.addBook(pb5);

        // Remove outdated books older than 10 years
        System.out.println("Quantum Bookstore: Removing books older than 10 years...");
        store.removeBooksOlderThan(10);

        // Buy a PaperBook
        try {
            double total = store.buyBook("1111", 2, "customer@example.com", "123 Main St");
            System.out.println("Quantum Bookstore: Purchase successful. Paid: $" + String.format("%.2f", total));
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Buy an EBook
        try {
            double total = store.buyBook("2222", 1, "customer@example.com", "");
            System.out.println("Quantum Bookstore: Purchase successful. Paid: $" + String.format("%.2f", total));
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Attempt to buy a PaperBook with insufficient stock
        try {
            store.buyBook("1111", 10, "customer@example.com", "123 Main St");
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
} 