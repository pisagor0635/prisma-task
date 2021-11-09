package com.ab.prismachallenge.repository;

import com.ab.prismachallenge.entity.Borrowed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowedRepository extends JpaRepository<Borrowed, Long> {

}
