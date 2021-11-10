package com.ab.prismachallenge.repository.fake;

import com.ab.prismachallenge.entity.Borrowed;
import com.ab.prismachallenge.entity.User;
import com.ab.prismachallenge.repository.BorrowedRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeBorrowedRepository implements BorrowedRepository {
    @Override
    public List<Borrowed> findAll() {

        List<Borrowed> borrowedList = new ArrayList<>();
        Borrowed borrowed1 = new Borrowed();
        borrowed1.setBorrower("Adnan,Bilgen");
        borrowed1.setBook("Advanced Java");
        borrowedList.add(borrowed1);

        Borrowed borrowed2 = new Borrowed();
        borrowed2.setBorrower("Adnan,Bilgen");
        borrowed2.setBook("Data Structure");
        borrowedList.add(borrowed2);

        return borrowedList;
    }

    @Override
    public List<Borrowed> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Borrowed> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Borrowed> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Borrowed entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Borrowed> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Borrowed> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Borrowed> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Borrowed> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Borrowed> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Borrowed> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Borrowed> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Borrowed getOne(Long aLong) {
        return null;
    }

    @Override
    public Borrowed getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Borrowed> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Borrowed> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Borrowed> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Borrowed> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Borrowed> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Borrowed> boolean exists(Example<S> example) {
        return false;
    }
}
