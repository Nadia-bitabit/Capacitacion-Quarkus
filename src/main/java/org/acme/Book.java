package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

//@Entity → Indica que es una entidad persistible
/*ACTIVE RECORD es otra forma de trabajar con la interaccion
de la ddbb, con la extención de PanacheEntity hace que
el objeto Book hace que la clase tenga todas las herramienta para
interactuar con la ddbb
* */
@Entity
public class Book /*extends PanacheEntity*/ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    private String title;
    private String author;
    private int pages;
    private String description;
    private LocalDate publishDate;
    @CreationTimestamp
    private LocalDate createDate;
    @UpdateTimestamp
    private LocalDate updateDate;

    public Book() {
    }

    public Book(String title, String author, int pages, String description, LocalDate publishDate) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.description = description;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
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
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numePages=" + pages +
                ", publishDate=" + publishDate +
                ", description=" + description + '\'' +
                '}';

    }
}
