package com.ab.prismachallenge.repository;

import com.ab.prismachallenge.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
