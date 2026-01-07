package org.acme;

import jakarta.ws.rs.core.Response;

import java.util.List;

public interface IBookService {
    List<Book> obtenerLibros();
    Response crearBook(Book book);
}
