package buchverwaltungssoftware.mybooks.authors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "authors")
public class Author {
    @Id
    private String authorId;
    private String authorFirstName;
    private String authorLastName;
    private int authorAge;
    private Date creationDate = new Date();

    public Author() {

    }
    
    public Author(String authorFirstName, String authorLastName, int authorAge) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorAge = authorAge;
    }

    // Getters and Setters
    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public int getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(int authorAge) {
        this.authorAge = authorAge;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
