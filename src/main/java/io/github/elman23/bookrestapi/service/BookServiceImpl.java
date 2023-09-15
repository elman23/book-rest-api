package io.github.elman23.bookrestapi.service;

import io.github.elman23.bookrestapi.dao.BookRepository;
import io.github.elman23.bookrestapi.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository employeeRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository) {
        employeeRepository = theBookRepository;
    }

    @Override
    public List<Book> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = employeeRepository.findById(theId);

        Book theBook = null;

        if (result.isPresent()) {
            theBook = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theBook;
    }

    @Override
    public Book save(Book theBook) {
        return employeeRepository.save(theBook);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}