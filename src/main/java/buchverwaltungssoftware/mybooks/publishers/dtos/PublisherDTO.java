package buchverwaltungssoftware.mybooks.publishers.dtos;

public class PublisherDTO {

    private Long publisherId;
    private String name;

    public PublisherDTO() {
    }

    public PublisherDTO(Long publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    // Getters and Setters
    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
