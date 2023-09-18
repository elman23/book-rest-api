package io.github.elman23.bookrestapi.mvc;

import io.github.elman23.bookrestapi.entity.Book;
import io.github.elman23.bookrestapi.rest.BookRestController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    private BookRestController restController;

    @Autowired
    public BookController(BookRestController restController) {
        this.restController = restController;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel) {

        theModel.addAttribute("book", new Book());

        return "book-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult) {

        if (theBindingResult.hasErrors()) {
            return "book-form";
        } else {

            restController.addBook(theBook);

            return "book-confirmation";
        }
    }
}
