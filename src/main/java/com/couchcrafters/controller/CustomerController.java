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


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
  

    @GetMapping("/addCustomer")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "addCustomer.html";
    }
    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer,@ModelAttribute("address") Address address){
        System.out.println(address.street);
        System.out.println(address.postCode);
        customer.setAddress(address);

        customerService.saveCustomer(customer);
        return "addCustomer.html";
    }

    // ab hier die Kunde ändern Funktionalität

    @GetMapping(value= { "/updateCustomer"})
    public String updateCustomer(Model model){
        List <Customer> customer = customerService.getAllCustomers();
        model.addAttribute("customers",customer);
        return "updateCustomer.html";
    }

    @PostMapping (value = {"/updateCustomer"})
    public String updateCustomer(@RequestParam("_id") String customerId,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("phone") String phone,
                             @RequestParam("address") String address){
        System.out.println("Selected CustomerId: " + customerId);
        customerService.updateCustomer(customerId, firstName, lastName, email, phone, address);
        return "redirect:/customerUpdatedSuccessfully";
    }

}
