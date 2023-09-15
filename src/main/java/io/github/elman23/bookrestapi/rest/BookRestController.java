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

    @GetMapping("/books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId) {

        Book theBook = bookService.findById(bookId);

        if (theBook == null) {
            throw new BookNotFoundException("Book id not found - " + bookId);
        }

        return theBook;
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book theBook) {

        theBook.setId(0);

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    @PutMapping("/books")
    public Book updateBook(@RequestBody Book theBook) {

        Book dbBook = bookService.save(theBook);

        return dbBook;
    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId) {

        Book tempBook = bookService.findById(bookId);

        if (tempBook == null) {
            throw new BookNotFoundException("Book with id not found - " + bookId);
        }

        bookService.deleteById(bookId);

        return "Deleted book with id - " + bookId;
    }
}