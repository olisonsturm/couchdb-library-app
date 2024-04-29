package com.couchcrafters.controller;

import com.couchcrafters.model.Address;
import com.couchcrafters.model.Customer;
import com.couchcrafters.service.BookService;
import com.couchcrafters.model.Book;
import com.couchcrafters.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer.html";
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "addCustomer.html";
    }

}
