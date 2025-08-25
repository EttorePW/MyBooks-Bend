package buchverwaltungssoftware.mybooks.authors;

import buchverwaltungssoftware.mybooks.authors.dtos.AuthorDTO;
import buchverwaltungssoftware.mybooks.authors.dtos.NewAuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAuthors() {
        return authorService.getAllAuthors();
    }
    @GetMapping("/{authorId}")
    public AuthorDTO getAuthorsById(@PathVariable String authorId) {
        return authorService.getAuthorById(authorId);
    }
    @PostMapping
    public AuthorDTO postAuthor(@RequestBody NewAuthorDTO newAuthorDTO) {
        return authorService.createAuthor(newAuthorDTO);
    }
    @PutMapping
    public AuthorDTO putAuthor(@RequestBody NewAuthorDTO newAuthorDTO) {
        return authorService.updateAuthor(newAuthorDTO);
    }
    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable String authorId) {
        authorService.deleteAuthor(authorId);
    }
}
