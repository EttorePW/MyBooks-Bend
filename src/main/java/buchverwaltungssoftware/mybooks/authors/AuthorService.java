package buchverwaltungssoftware.mybooks.authors;

import buchverwaltungssoftware.mybooks.authors.dtos.AuthorDTO;
import buchverwaltungssoftware.mybooks.authors.dtos.NewAuthorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDTO createAuthor(NewAuthorDTO newAuthorDTO) {
        Author newAuthor = new Author(newAuthorDTO.getAuthorFirstName(), newAuthorDTO.getAuthorLastName(), newAuthorDTO.getAuthorAge());
        authorRepository.save(newAuthor);

        return convertAuthorToAuthorDTO(newAuthor);
    }
    public AuthorDTO convertAuthorToAuthorDTO(Author author) {

        return new AuthorDTO(author.getAuthorId(), author.getAuthorFirstName(), author.getAuthorLastName());
    }
    public NewAuthorDTO convertAuthorToNewAuthorDTO(Author author) {
        return new NewAuthorDTO(author.getAuthorFirstName(), author.getAuthorLastName(),author.getAuthorAge());
    }

    public List<AuthorDTO> getAllAuthors() {
        ArrayList<AuthorDTO> authorDTOList = new ArrayList<>();
        authorRepository.findAll().forEach(author -> authorDTOList.add(convertAuthorToAuthorDTO(author)));
        return authorDTOList;
    }

    public AuthorDTO getAuthorById(Long id) {
        return convertAuthorToAuthorDTO(authorRepository.getReferenceById(id));
    }

    public AuthorDTO updateAuthor(NewAuthorDTO newAuthorDTO) {
        Author newAuthor = new Author(newAuthorDTO.getAuthorFirstName(), newAuthorDTO.getAuthorLastName(), newAuthorDTO.getAuthorAge());
        authorRepository.save(newAuthor);
        return convertAuthorToAuthorDTO(newAuthor);
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
