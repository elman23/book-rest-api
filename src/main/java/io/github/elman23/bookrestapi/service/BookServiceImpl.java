package io.github.elman23.bookrestapi.service;

import io.github.elman23.bookrestapi.dao.BookRepository;
import io.github.elman23.bookrestapi.entity.Book;
import io.github.elman23.bookrestapi.rest.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        bookRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            throw new BookNotFoundException("Did not find book with id - " + theId);
        }

        return theBook;
    }

    @Override
    @Transactional
    public Book save(Book theBook) {
        return bookRepository.save(theBook);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}