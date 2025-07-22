package buchverwaltungssoftware.mybooks.publishers;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long publisherId;
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
    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
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
