package buchverwaltungssoftware.mybooks.publishers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "publishers")
public class Publisher {

    @Id
    private String publisherId;
    private String name;
    private String email;
    private Date createdDate = new Date();

    public Publisher( String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Publisher() {

    }

    // Getters and Setters
    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
