package buchverwaltungssoftware.mybooks.books;

import buchverwaltungssoftware.mybooks.books.dtos.NewBookDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}
