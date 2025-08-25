package buchverwaltungssoftware.mybooks.publishers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends MongoRepository<Publisher, String> {

}
