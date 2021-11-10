package com.ab.prismachallenge.service;

import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.repository.fake.FakeBorrowedRepository;
import com.ab.prismachallenge.repository.fake.FakeUserRepository;
import com.ab.prismachallenge.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("UserServiceTest")
class UserServiceTest {

    @DisplayName("usersBorrowedAtLeastOneBook")
    @Test
    void getUsersBorrowedAtLeastOne() {

        UserService userService = new UserServiceImpl(new FakeUserRepository(), new FakeBorrowedRepository());

        List<User> users = userService.getUsersBorrowedAtLeastOne();

        Assertions.assertEquals(Boolean.TRUE, users.size() > 0);

    }
}
