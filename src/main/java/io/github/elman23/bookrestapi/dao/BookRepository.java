package io.github.elman23.bookrestapi.dao;

import io.github.elman23.bookrestapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
