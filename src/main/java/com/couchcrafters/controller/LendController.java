package com.couchcrafters.controller;

import com.couchcrafters.model.Book;
import com.couchcrafters.model.Lending;
import com.couchcrafters.service.LendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class LendController {
    @Autowired
    LendService lendService;

    public LendController(LendService lendService) {
        this.lendService = lendService;
    }

    @GetMapping("/createLend")
    public String createLend(Model model){
        model.addAttribute("lend", new Lending());
        return "createLend.html";
    }
    @PostMapping("/createLend")
    public  String createLend(@ModelAttribute("lend") Lending lend){
        lendService.saveLending(lend);
        return "createLend.html";
    }



}
