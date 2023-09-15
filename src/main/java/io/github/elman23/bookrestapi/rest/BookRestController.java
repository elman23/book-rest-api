package io.github.elman23.bookrestapi.rest;

import io.github.elman23.bookrestapi.entity.Book;
import io.github.elman23.bookrestapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public BookRestController(BookService theBookService) {
        bookService = theBookService;
    }

    // expose "/books" and return a list of book
    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    // add mapping for GET /books/{bookId}

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        return theBook;
    }

    // add mapping for POST /books - add new employee

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theBook.setId(0);

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    // add mapping for PUT /books - update existing employee

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    // add mapping for DELETE /books/{bookId} - delete employee

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {

        Book tempBook = bookService.findById(bookId);

        // throw exception if null

        if (tempBook == null) {
            throw new RuntimeException("Book id not found - " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted employee id - " + bookId;
    }

}