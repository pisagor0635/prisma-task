package com.ab.prismachallenge.service;

import com.ab.prismachallenge.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsersBorrowedAtLeastOne();

    List<User> getNonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything();

    List<User> getUsersBorrowedOnAGivenDate(String date);
}
