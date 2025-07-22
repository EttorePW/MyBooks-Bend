package buchverwaltungssoftware.mybooks.books.dtos;

public class BookDTO {
    private Long bookId;
    private String title;
    private String description;
    private boolean hasFinished;
    private String author;
    private String publisher;
    private String category;
    private String place;

    public BookDTO() {
    }

    public BookDTO(Long bookId, String title, String description, boolean hasFinished, 
                   String author, String publisher, String category, String place) {
        this.bookId = bookId;
        this.title = title;
        this.description = description;
        this.hasFinished = hasFinished;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.place = place;
    }

    // Getters and Setters
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasFinished() {
        return hasFinished;
    }

    public void setHasFinished(boolean hasFinished) {
        this.hasFinished = hasFinished;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
