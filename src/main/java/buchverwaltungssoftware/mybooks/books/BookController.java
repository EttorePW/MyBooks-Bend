package buchverwaltungssoftware.mybooks.books;

import buchverwaltungssoftware.mybooks.books.dtos.BookDTO;
import buchverwaltungssoftware.mybooks.books.dtos.NewBookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getBooks() {
        return bookService.getAllBooks();
    }
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }
    @PostMapping
    public BookDTO postBook(@RequestBody NewBookDTO newBookDTO) {
        System.out.println(newBookDTO.getPlace());
        System.out.println(bookService.createBookDTO(newBookDTO).getPlace());
        return bookService.createBookDTO(newBookDTO);
    }
    @PutMapping("/{id}")
    public BookDTO putBook(@PathVariable String id, @RequestBody NewBookDTO newBookDTO) {
        return bookService.updateBook(id, newBookDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookService.deleteBookById(id);
    }
}
