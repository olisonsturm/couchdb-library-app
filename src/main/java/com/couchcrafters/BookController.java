package com.couchcrafters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;


@Controller
public class BookController {

    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
