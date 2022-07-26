package com.cts.spring.boot.datajpa.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.boot.datajpa.demo.entity.Book;

public interface BookRepo extends JpaRepository<Book,Long> {

}
