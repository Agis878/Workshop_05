package pl.coderslab.dao;


import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getBooks();


    Optional<Book> get(Long id);


    void add(Book book);


    void delete(Long id);


    void update(Long id, Book updateBook);

}