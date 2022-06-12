package org.shunin.controllers;


import org.shunin.dao.BookDAO;
import org.shunin.dao.PersonDAO;
import org.shunin.models.Book;
import org.shunin.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;


    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;

    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("book", bookDAO.index());
        return "libra/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "libra/show";
    }

    @GetMapping("/new")
    public String addBook(@ModelAttribute("newbook") Book book) {
        return "libra/new";
    }

    @PostMapping()
    public String saveBook(@ModelAttribute("newbook") @Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "books/new";
        }
        bookDAO.save(book);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "libra/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") int id) {
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete( @PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
