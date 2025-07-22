package buchverwaltungssoftware.mybooks.books;

import buchverwaltungssoftware.mybooks.books.dtos.NewBookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
