package buchverwaltungssoftware.mybooks.authors.dtos;

public class AuthorDTO {

    private String authorId;
    private String authorFirstName;
    private String authorLastName;

    public AuthorDTO() {
    }

    public AuthorDTO(String authorId, String authorFirstName, String authorLastName) {
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
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
}
