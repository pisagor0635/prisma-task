package com.ab.prismachallenge.controller;

import com.ab.prismachallenge.entity.Book;
import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.service.BookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/borrowed")
    @ApiOperation(value = "returns all books borrowed by a given user in a given date range")
    public ResponseEntity<List<Book>> getBooksBorrowedByAGivenUserInAGivenDateRange(@RequestBody User user, @RequestParam String dateFrom, @RequestParam String dateTo) {
        return ResponseEntity.ok(bookService.getBooksBorrowedByAGivenUserInAGivenDateRange(user, dateFrom, dateTo));
    }


    @GetMapping("/available")
    @ApiOperation(value = "returns all available (not borrowed) books")
    public ResponseEntity<List<Book>> getAvailableBooks() {
        return ResponseEntity.ok(bookService.getAvailableBooks());
    }
}
