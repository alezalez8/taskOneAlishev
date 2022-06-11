package org.shunin.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {


    @GetMapping()
    public String index(Model model) {
        //model.addAttribute("book", Book book)

        return "/index";
    }

}
