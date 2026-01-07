package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

//Es la clase que me permite enviar query a la ddbb
@ApplicationScoped
public class BookRepository implements PanacheRepository <Book> {

}
