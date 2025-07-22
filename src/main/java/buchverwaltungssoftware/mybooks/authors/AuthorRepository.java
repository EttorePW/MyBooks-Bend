package buchverwaltungssoftware.mybooks.authors;

import buchverwaltungssoftware.mybooks.authors.dtos.NewAuthorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
