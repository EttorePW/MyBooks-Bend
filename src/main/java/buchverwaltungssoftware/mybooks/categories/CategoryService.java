package buchverwaltungssoftware.mybooks.categories;


import buchverwaltungssoftware.mybooks.categories.dtos.CategoryDTO;
import buchverwaltungssoftware.mybooks.categories.dtos.NewCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(NewCategoryDTO newCategoryDTO) {
        Category category = new Category(newCategoryDTO.getCategoryName());
        categoryRepository.save(category);
        return convertCategoryToDTO(category);
    }
    public CategoryDTO convertCategoryToDTO(Category category) {
        return new CategoryDTO(category.getCategoryId(),category.getCategoryName());
    }
    public NewCategoryDTO convertCategoryToNewCategoryDTO(Category category) {
        return  new NewCategoryDTO(category.getCategoryName());
    }

    public List<CategoryDTO> getAll() {
        List<CategoryDTO> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(category -> categories.add(convertCategoryToDTO(category)));
        return categories;
    }

    public CategoryDTO getCategorieById(Long id) {
        return convertCategoryToDTO(categoryRepository.findById(id).orElse(new Category()));
    }

    public CategoryDTO updateCategorie(NewCategoryDTO newCategoryDTO) {
        Category category = new Category(newCategoryDTO.getCategoryName());
        categoryRepository.save(category);
        return convertCategoryToDTO(category);
    }
    public void deleteCategorieById(Long id) {
        categoryRepository.deleteById(id);
    }
}
