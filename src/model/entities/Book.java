package model.entities;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private String publicationYear;

    public Book() {
    }

    public Book(Integer id, String title, String author, String publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    
}
