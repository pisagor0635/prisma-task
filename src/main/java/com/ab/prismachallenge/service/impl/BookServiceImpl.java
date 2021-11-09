package com.ab.prismachallenge.service.impl;

import com.ab.prismachallenge.entity.Book;
import com.ab.prismachallenge.entity.Borrowed;
import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.repository.BookRepository;
import com.ab.prismachallenge.repository.BorrowedRepository;
import com.ab.prismachallenge.service.BookService;
import com.ab.prismachallenge.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BorrowedRepository borrowedRepository;

    private final BookRepository bookRepository;

    @Override
    public List<Book> getBooksBorrowedByAGivenUserInAGivenDateRange(User user, String dateFrom, String dateTo) {

        List<Borrowed> borrowedList = borrowedRepository.findAll().stream().filter(b -> b.getBorrower().equals(user.getName() + "," + user.getFirstName()) &&
                DateUtil.convertStringToDate(b.getBorrowedFrom()).after(DateUtil.convertStringToDate(dateFrom)) &&
                (DateUtil.convertStringToDate(b.getBorrowedTo()).before(DateUtil.convertStringToDate(dateTo)))).collect(Collectors.toList());

        List<String> nameOfBorrowedBooks = borrowedList.stream().map(b -> b.getBook()).collect(Collectors.toList());

        return bookRepository.findAll().stream().filter(b -> nameOfBorrowedBooks.contains(b.getTitle())).collect(Collectors.toList());
    }

    @Override
    public List<Book> getAvailableBooks() {

        List<String> nameOfBorrowedBooks = borrowedRepository.findAll().stream().filter(b -> DateUtil.convertStringToDate(b.getBorrowedFrom()).before(new Date()) &&
                (DateUtil.convertStringToDate(b.getBorrowedTo()).after(new Date()))).collect(Collectors.toList()).stream().map(b -> b.getBook()).collect(Collectors.toList());
        ;
        List<Book> books = bookRepository.findAll();

        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books) {
            if (!nameOfBorrowedBooks.contains(book.getTitle())) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
}
