package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.dao.Book;
import pl.coderslab.dao.MockBookService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final MockBookService mockBookService;
//    @RequestMapping(value = "/helloBook", produces = MediaType.APPLICATION_JSON_VALUE)
//        public Book helloBook() {
//            return new Book(1L, "9788324631766", "Thinking in Java","Bruce Eckel", "Helion", "programming");
//
//        }

    @GetMapping
    public List<Book> showAllBooks() {
            return  mockBookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        mockBookService.add(book);
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable Long id) {
        return mockBookService.get(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found"));
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        mockBookService.update(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable Long id) {
    mockBookService.delete(id);
    }
}

