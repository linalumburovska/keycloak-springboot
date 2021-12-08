package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class BookController {

    @Autowired
    private BookDAO bookDAO;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/books")
    public String customers(Principal principal, Model model) {
        addBooks();
        model.addAttribute("books", bookDAO.findAll());
        return "books";
    }

    // add books for demonstration
    public void addBooks() {

        Book book1 = new Book();
        book1.setName("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        book1.setYear("1925");
        bookDAO.save(book1);

        Book book2 = new Book();
        book2.setName("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setYear("1960");
        bookDAO.save(book2);

        Book book3 = new Book();
        book3.setName("The Lord of the Rings");
        book3.setAuthor("J. R. R. Tolkien");
        book3.setYear("1954");
        bookDAO.save(book3);
    }
}
