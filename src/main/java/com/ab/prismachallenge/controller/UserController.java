package com.ab.prismachallenge.controller;

import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/borrowedatleastone")
    @ApiOperation(value = "returns all users who have actually borrowed at least one book")
    public ResponseEntity<List<User>> getUsersBorrowedAtLeastOne() {
        return ResponseEntity.ok(userService.getUsersBorrowedAtLeastOne());
    }

    @GetMapping("/notcurrentlyborrowed")
    @ApiOperation(value = "returns all non-terminated users who have not currently borrowed anything")
    public ResponseEntity<List<User>> getNonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything() {
        return ResponseEntity.ok(userService.getNonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything());
    }


    @GetMapping("/borrowed")
    @ApiOperation(value = "returns all users who have borrowed a book on a given date")
    public ResponseEntity<List<User>> getUsersBorrowedOnAGivenDate(@RequestParam String date) {
        return ResponseEntity.ok(userService.getUsersBorrowedOnAGivenDate(date));
    }


}
