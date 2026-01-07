package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class BookService implements IBookService {
    @Inject
    BookRepository bookRepository;

    //private List<Book> libros = new ArrayList<>();

    @Override
    public List<Book> obtenerLibros() {
        //Collections.unmodifiableList(libros);
        return bookRepository.listAll();
    }

    @Override
    public Response crearBook(Book book) {
        //libros.add(book);
        bookRepository.persist(book);
        return Response.ok(book).status(201).build();
    }
}
