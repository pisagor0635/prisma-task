package com.ab.prismachallenge.service.impl;

import com.ab.prismachallenge.entity.Borrowed;
import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.repository.BorrowedRepository;
import com.ab.prismachallenge.repository.UserRepository;
import com.ab.prismachallenge.service.UserService;
import com.ab.prismachallenge.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BorrowedRepository borrowedRepository;

    @Override
    public List<User> getUsersBorrowedAtLeastOne() {

        List<Borrowed> borrowedList = borrowedRepository.findAll();
        List<String> borrowers = borrowedList.stream().map(Borrowed::getBorrower).distinct().collect(Collectors.toList());
        List<User> users = userRepository.findAll();
        return users.stream().filter(u -> borrowers.contains(u.getName() + "," + u.getFirstName())).collect(Collectors.toList());
    }

    @Override
    public List<User> getNonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything() {

        List<String> borrowers = borrowedRepository.findAll().stream().map(Borrowed::getBorrower).distinct().collect(Collectors.toList());
        List<User> users = userRepository.findAll();

        List<User> nonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything = new ArrayList<>();

        for (User u : users) {
            if ((u.getMemberTill() == null || DateUtil.convertStringToDate(u.getMemberTill()).after(new Date()))
                    && (!borrowers.contains(u.getName() + "," + u.getFirstName()))) {
                nonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything.add(u);
            }
        }
        return nonTerminatedUsersWhoHaveNotCurrentlyBorrowedAnything;
    }

    @Override
    public List<User> getUsersBorrowedOnAGivenDate(String date) {

        List<String> borrowers = borrowedRepository.findAll().stream().filter(b -> (DateUtil.convertStringToDate(b.getBorrowedFrom())
                        .before(DateUtil.convertStringToDate(date)) && (DateUtil.convertStringToDate(b.getBorrowedTo())
                        .after(DateUtil.convertStringToDate(date))))).collect(Collectors.toList())
                .stream().map(Borrowed::getBorrower).distinct().collect(Collectors.toList());

        List<User> users = userRepository.findAll();

        return users.stream().filter(u -> borrowers.contains(u.getName() + "," + u.getFirstName())).collect(Collectors.toList());
    }
}
