package com.ab.prismachallenge.service;

import com.ab.prismachallenge.entity.Book;
import com.ab.prismachallenge.entity.User;

import java.util.List;

public interface BookService {
    List<Book> getBooksBorrowedByAGivenUserInAGivenDateRange(User user, String dateFrom, String dateTo);

    List<Book> getAvailableBooks();
}
