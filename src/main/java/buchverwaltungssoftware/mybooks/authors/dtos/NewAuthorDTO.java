package buchverwaltungssoftware.mybooks.authors.dtos;

public class NewAuthorDTO {
    private String authorFirstName;
    private String authorLastName;
    private int authorAge;

    public NewAuthorDTO() {
    }

    public NewAuthorDTO(String authorFirstName, String authorLastName, int authorAge) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorAge = authorAge;
    }

    // Getters and Setters
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
}
