package pl.coderslab.dao;

import lombok.Getter;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Getter
public class MockBookService implements BookService{

    private List<Book> list = new ArrayList<>();

   public MockBookService() {
       list = new ArrayList<>();
       list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
       list.add(new Book(2L, "9781234567890", "Clean Code", "Robert C. Martin", "Prentice Hall", "programming"));
       list.add(new Book(3L, "9780123456789", "The Pragmatic Programmer", "Andrew Hunt, David Thomas", "Addison-Wesley Professional", "programming"));
       list.add(new Book(4L, "9789876543210", "To Kill a Mockingbird", "Harper Lee", "J. B. Lippincott & Co.", "fiction"));
       list.add(new Book(5L, "9784567891234", "1984", "George Orwell", "Secker & Warburg", "fiction"));
   }
    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
       return list.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst();
       }

    @Override
    public void add(Book book) {
        list.add(book);
    }

    @Override
    public void delete(Long id) {
        if (get(id).isPresent()) {
            list.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {

       if (this.get(book.getId()).isPresent()) {
           int indexOf = list.indexOf(this.get(book.getId()).get());
           list.set(indexOf,book);
    }

    }
}