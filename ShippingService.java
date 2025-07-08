// Handle shipping of physical books
public class ShippingService {
    public static void ship(PaperBook book, String address, int quantity) {
        System.out.println("Quantum Bookstore: Shipping " + quantity + " copy(ies) of '" + book.getTitle() + "' to " + address);
    }
} 