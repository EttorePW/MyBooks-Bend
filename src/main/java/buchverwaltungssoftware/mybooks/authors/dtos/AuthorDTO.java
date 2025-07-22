package buchverwaltungssoftware.mybooks.authors.dtos;

public class AuthorDTO {

    private Long authorId;
    private String authorFirstName;
    private String authorLastName;

    public AuthorDTO() {
    }

    public AuthorDTO(Long authorId, String authorFirstName, String authorLastName) {
        this.authorId = authorId;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }

    // Getters and Setters
    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
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
