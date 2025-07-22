package buchverwaltungssoftware.mybooks.categories.dtos;

public class NewCategoryDTO {

    private String categoryName;

    public NewCategoryDTO() {
    }

    public NewCategoryDTO(String categoryName) {
        this.categoryName = categoryName;
    }

    // Getters and Setters
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
