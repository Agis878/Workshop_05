package pl.coderslab.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dao.Book;


@RestController
    @RequestMapping("/books")
    public class BookController {
    @RequestMapping(value = "/helloBook", produces = MediaType.APPLICATION_JSON_VALUE)
        public Book helloBook() {

            return new Book(1L, "9788324631766", "Thinking in Java","Bruce Eckel", "Helion", "programming");

        }
    }

