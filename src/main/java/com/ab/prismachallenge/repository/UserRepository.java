package com.ab.prismachallenge.repository;

import com.ab.prismachallenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
