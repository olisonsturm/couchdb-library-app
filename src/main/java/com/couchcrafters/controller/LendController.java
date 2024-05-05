package com.couchcrafters.controller;

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

@Slf4j
@Controller
public class LendController {
    @Autowired
    LendService lendService;

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;

    public LendController(LendService lendService, BookService bookService,CustomerService customerService) {
        this.lendService = lendService;
        this.bookService = bookService;
        this.customerService = customerService;
    }


    @GetMapping("/createLend")
    public String createLend(Model model){


        model.addAttribute("books", bookService.getAllTitlesAndAuthors());
        model.addAttribute("customers", customerService.getAllNamesAndEmails());
        model.addAttribute("lend", new Lending());
        return "createLend.html";
    }
    @PostMapping("/createLend")
    public  String createLend(@ModelAttribute("lend") Lending lend){
        if(lendService.saveLending(lend)){
            return "redirect:/createdLend";
        }else{
            return "redirect:/error";
        }

    }


    @GetMapping("/createdLend")
    public String createdLend(){
        return "createdLend.html";
    }
    @GetMapping("/error")
    public String error(){
        return "error.html";
    }

    @GetMapping("/returnLending")
    public String returnLending(Model model){
        model.addAttribute("lends",lendService.getAllCurrentLends());
        model.addAttribute("lending",new JsonObject());
        return "returnLending.html";
    }

    @PostMapping("/returnLending")
    public String returnLending(@RequestParam("value") String selectedId) {
        System.out.println("Selected value: " + selectedId);
        lendService.updateLend(selectedId);
        return "redirect:/";
    }

}
