package com.couchcrafters.controller;

import com.couchcrafters.service.BookService;
import com.couchcrafters.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Slf4j
@Controller
public class BookController {

    @Autowired
    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"/"})
    public String index() {
        return "index.html";
    }

    @GetMapping(value = {"/addBook"})
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook.html";
    }

    @GetMapping(value = {"/bookStats"})
    public String allBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        for(Book b : books){
            System.out.println(b.getTitle());
        }
        model.addAttribute("books",books);
        return "bookStats.html";
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/addedBook";
    }
    @GetMapping(value = {"/addedBook"})
    public String addedBook(Model model) {
        return "addedBook.html";
    }
}
