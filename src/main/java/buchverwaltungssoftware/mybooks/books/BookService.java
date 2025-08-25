package buchverwaltungssoftware.mybooks.books;

import buchverwaltungssoftware.mybooks.authors.Author;
import buchverwaltungssoftware.mybooks.authors.AuthorRepository;
import buchverwaltungssoftware.mybooks.books.dtos.BookDTO;
import buchverwaltungssoftware.mybooks.books.dtos.NewBookDTO;
import buchverwaltungssoftware.mybooks.categories.Category;
import buchverwaltungssoftware.mybooks.categories.CategoryRepository;
import buchverwaltungssoftware.mybooks.publishers.Publisher;
import buchverwaltungssoftware.mybooks.publishers.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public BookDTO createBookDTO(NewBookDTO newBookDTO) {
        Book book = new Book(newBookDTO.getTitle(), newBookDTO.getDescription(), newBookDTO.isHasFinished(), getBookByAuthorName(newBookDTO), getBookByPublisher(newBookDTO), getBookCategory(newBookDTO), newBookDTO.getPlace());
        bookRepository.save(book);
        return convertBookToBookDTO(book);
    }
    public BookDTO convertBookToBookDTO(Book book) {

        return new BookDTO(book.getBookId(),book.getTitle(), book.getDescription(), book.isHasFinished(),(book.getAuthor().getAuthorFirstName() +" "+ book.getAuthor().getAuthorLastName()), book.getPublisher().getName(), book.getCategory().getCategoryName(), book.getPlace());
    }
    public NewBookDTO convertBookToNewBookDTO(Book book) {

        return  new NewBookDTO(book.getTitle(), book.getDescription(), book.isHasFinished(),book.getAuthor().getAuthorFirstName() +" "+ book.getAuthor().getAuthorLastName(), book.getPublisher().getName(), book.getCategory().getCategoryName(), book.getPlace());

    }
    public BookDTO updateBook(String id,NewBookDTO newBookDTO){
        bookRepository.findById(id)
                .map(book -> {
                    book.setHasFinished(newBookDTO.isHasFinished());
                    return book;
                })
                .orElseThrow(() -> new RuntimeException("Book with ID " + id + " not found"));
        return null;
    }
    public BookDTO getBookById(String id) {

        return convertBookToBookDTO(bookRepository.findById(id).orElse(null));

    }
    public Author getBookByAuthorName(NewBookDTO newBookDTO) {
        return authorRepository.findAll().stream()
                .filter(author -> (author.getAuthorFirstName() + " " + author.getAuthorLastName())
                        .equalsIgnoreCase(newBookDTO.getAuthor()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Autor no encontrado: " + newBookDTO.getAuthor()));
    }

    public Publisher getBookByPublisher(NewBookDTO newBookDTO) {
        return publisherRepository.findAll().stream()
                .filter(publisher -> publisher.getName().equalsIgnoreCase(newBookDTO.getPublisher()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Editor no encontrado: " + newBookDTO.getPublisher()));
    }

    public Category getBookCategory(NewBookDTO newBookDTO) {
        return categoryRepository.findAll().stream()
                .filter(category -> category.getCategoryName().equalsIgnoreCase(newBookDTO.getCategory()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada: " + newBookDTO.getCategory()));
    }

    public List<BookDTO> getAllBooks() {
        List<Book> booksList = bookRepository.findAll();
        List<BookDTO> newBookDTOList = new ArrayList<>();
        booksList.forEach(book -> {newBookDTOList.add(convertBookToBookDTO(book));});
        return newBookDTOList;

    }
    public void deleteBookById(String id) {

        bookRepository.deleteById(id);
    }

}
