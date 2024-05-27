package com.couchcrafters.controller;

import com.couchcrafters.model.Book;
import com.couchcrafters.model.Lending;
import com.couchcrafters.service.BookService;
import com.couchcrafters.service.CustomerService;
import com.couchcrafters.service.LendService;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
public class StatistikController {
    @Autowired
    LendService lendService;

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;

    public StatistikController(LendService lendService, BookService bookService,CustomerService customerService) {
        this.lendService = lendService;
        this.bookService = bookService;
        this.customerService = customerService;
    }


    @GetMapping("/statistic")
    public String lendStats(Model model){
        model.addAttribute("returnedCount",lendService.getFilteredLendCount(true));
        model.addAttribute("notReturnedCount",lendService.getFilteredLendCount(false));
        model.addAttribute("genreData", bookService.groupGenres());
        model.addAttribute("groupYear", bookService.groupYear());
        model.addAttribute("mostLendedBook", lendService.mostLendedBooks());


        return "statistic2.html";
    }
}
