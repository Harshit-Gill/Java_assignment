class Book {
    private String title;
    private String author;
    private String bookCode;
    private boolean loaned;

    public Book(String title, String author, String bookCode) {
        if (title == null || title.isBlank()) {
           System.out.println("Book title can never be null");
           return;
        }

        if (author == null || author.isBlank()) {
            System.out.println("Author can never be null");
            return;
        }

        if (bookCode == null || bookCode.isBlank()) {
            System.out.println("BookCode can never be null");
            return;
        }

        this.title = title;
        this.author = author;
        this.bookCode = bookCode;
        this.loaned = false;
    }
    public boolean borrowBook() {
        if (loaned) {
            return false; // Already borrowed
        }

        loaned = true;
        return true;
    }
    public boolean returnBook() {
        if (!loaned) {
            return false; // Already available
        }

        loaned = false;
        return true;
    }

    public boolean isAvailable() {
        return !loaned;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getBookCode() {
        return bookCode;
    }
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", bookCode='" + bookCode + '\'' +
                ", available=" + isAvailable() +
                '}';
    }
}
