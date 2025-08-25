package buchverwaltungssoftware.mybooks.authors;

import buchverwaltungssoftware.mybooks.authors.dtos.NewAuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
}
