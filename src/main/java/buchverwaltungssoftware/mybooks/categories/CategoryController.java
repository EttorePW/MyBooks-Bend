package buchverwaltungssoftware.mybooks.categories;

import buchverwaltungssoftware.mybooks.categories.dtos.CategoryDTO;
import buchverwaltungssoftware.mybooks.categories.dtos.NewCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryService.getCategorieById(id);
    }
    @PostMapping
    public CategoryDTO postCategory(@RequestBody NewCategoryDTO newCategoryDTO) {
        return categoryService.createCategory(newCategoryDTO);
    }
    @PutMapping
    public CategoryDTO putCategory(@RequestBody NewCategoryDTO newCategoryDTO) {
        return categoryService.updateCategorie(newCategoryDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.deleteCategorieById(id);
    }

}
