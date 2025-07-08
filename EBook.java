// Digital book with file type
public class EBook extends Book {
    private final String fileType;

    public EBook(String isbn, String title, String author, int yearPublished, double price, String fileType) {
        super(isbn, title, author, yearPublished, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }
} 