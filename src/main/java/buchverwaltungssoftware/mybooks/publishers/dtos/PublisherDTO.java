package buchverwaltungssoftware.mybooks.publishers.dtos;

public class PublisherDTO {

    private String publisherId;
    private String name;

    public PublisherDTO() {
    }

    public PublisherDTO(String publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    // Getters and Setters
    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
