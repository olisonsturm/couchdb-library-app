package com.couchcrafters.controller;

import com.couchcrafters.service.BookService;
import com.couchcrafters.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Slf4j
@Controller
public class BookController {

    @GetMapping(value = {"/"})
    public String index() {
        return "index.html";
    }

    @GetMapping(value = {"/addBook"})
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addBook.html";
    }

    @GetMapping(value = {"/contact"})
    public String contact() {
        return "contact.html";
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute("book") Book book) {

        BookService.buchSpeichern(book);
        return "redirect:/";
    }
}
