package buchverwaltungssoftware.mybooks.publishers;


import buchverwaltungssoftware.mybooks.publishers.dtos.NewPublisherDTO;
import buchverwaltungssoftware.mybooks.publishers.dtos.PublisherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    public PublisherDTO create(NewPublisherDTO newPublisherDTO) {
        Publisher publisher = new Publisher(newPublisherDTO.getName(), newPublisherDTO.getEmail());
        publisherRepository.save(publisher);
        return convertPublisherToPublisherDTO(publisher);
    }
    public PublisherDTO convertPublisherToPublisherDTO(Publisher publisher) {
        return new PublisherDTO(publisher.getPublisherId(),publisher.getName());
    }
    public NewPublisherDTO convertPublisherToNewPublisherDTO(Publisher publisher) {
        return  new NewPublisherDTO(publisher.getName(), publisher.getEmail());
    }

    public List<PublisherDTO> getAll() {
        List<PublisherDTO> publishers = new ArrayList<>();
        publisherRepository.findAll().forEach(publisher -> publishers.add(convertPublisherToPublisherDTO(publisher)));
        return publishers;
    }

    public PublisherDTO getPublisherById(Long id) {
        return convertPublisherToPublisherDTO(publisherRepository.findById(id).orElse(new Publisher()));
    }

    public PublisherDTO updatePublisher(NewPublisherDTO newPublisherDTO) {
        Publisher publisher = new Publisher(newPublisherDTO.getName(), newPublisherDTO.getEmail());
        publisherRepository.save(publisher);
        return convertPublisherToPublisherDTO(publisher);
    }
    public void deletePublisherById(Long id) {
        publisherRepository.deleteById(id);
    }

}
