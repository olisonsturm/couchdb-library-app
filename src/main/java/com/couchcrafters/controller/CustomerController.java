package com.couchcrafters.controller;

import com.couchcrafters.model.Address;
import com.couchcrafters.model.Customer;
import com.couchcrafters.service.BookService;
import com.couchcrafters.model.Book;
import com.couchcrafters.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Slf4j
@Controller
public class CustomerController {



    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("address", new Address());
        return "addCustomer.html";
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer,@ModelAttribute("address") Address address){
        System.out.println(address.street);
        System.out.println(address.postCode);
        customer.setAddress(address);
        CustomerService.saveCustomer(customer);
        return "addCustomer.html";
    }

}
