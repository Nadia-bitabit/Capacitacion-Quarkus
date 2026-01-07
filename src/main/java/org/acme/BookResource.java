package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/books")
@Transactional
public class BookResource {

    private final BookService books;

    @Inject
    public BookResource (BookService books) {
        this.books = books;
    }

    //Active recoord: Se llama al objeto- recomendacion, crear el bookservice, apartar la logica de negocio
    /*@GET
    public List<Book> getBooks() {
        return Book.listAll();
    }*/

    //Active recoord: Se llama al objeto- recomendacion, crear el bookservice, apartar la logica de negocio
   /* @POST
    public Book createBook(Book book) {
        book.persist();
        return book;
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return books.obtenerLibros();
    }

    @POST
    public Book createBook(Book book) {
        books.crearBook(book);
        return book;
    }

}
