package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;

    @RestController
    @RequestMapping("books")
    public class BookController {
        @RequestMapping("helloBook")
        public String helloBook() {

            return "cos";
        }
    }

