package buchverwaltungssoftware.mybooks.publishers;


import buchverwaltungssoftware.mybooks.publishers.dtos.NewPublisherDTO;
import buchverwaltungssoftware.mybooks.publishers.dtos.PublisherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> getAll() {
        return publisherService.getAll();
    }
    @GetMapping("/{id}")
    public PublisherDTO getById(@PathVariable Long id) {
        return publisherService.getPublisherById(id);
    }
    @PostMapping
    public PublisherDTO postPublisher(@RequestBody NewPublisherDTO newPublisherDTO) {
        return publisherService.create(newPublisherDTO);
    }
    @PutMapping
    public PublisherDTO putPublisher(@RequestBody NewPublisherDTO newPublisherDTO) {
        return publisherService.updatePublisher(newPublisherDTO);
    }
    @DeleteMapping("/{id}")
    public void deletePublisherById(@PathVariable Long id) {
        publisherService.deletePublisherById(id);
    }
}
