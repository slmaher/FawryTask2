//  displayed when a requested book is not available for purchase
public class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
} 