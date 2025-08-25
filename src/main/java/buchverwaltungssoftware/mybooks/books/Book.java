package buchverwaltungssoftware.mybooks.books;

import buchverwaltungssoftware.mybooks.authors.Author;
import buchverwaltungssoftware.mybooks.categories.Category;
import buchverwaltungssoftware.mybooks.publishers.Publisher;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Document(collection = "books")
public class Book {

    @Id
    private String bookId;
    private String title;
    private String description;
    private boolean hasFinished;
    @DBRef
    private Author author;
    @DBRef
    private Publisher publisher;
    @DBRef
    private Category category;
    private String place;
    private Date createdDate = new Date();

    public Book(){

    }

    public Book(String title, String description, boolean hasFinished, Author author, Publisher publisher, Category category, String place) {
        this.title = title;
        this.description = description;
        this.hasFinished = hasFinished;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.place = place;
    }

    // Getters and Setters
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
