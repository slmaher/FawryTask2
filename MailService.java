// Handles sending of digital books via email
public class MailService {
    public static void send(EBook book, String email, int quantity) {
        System.out.println("Quantum Bookstore: Sending " + quantity + " copy(ies) of '" + book.getTitle() + "' (" + book.getFileType() + ") to " + email);
    }
} 