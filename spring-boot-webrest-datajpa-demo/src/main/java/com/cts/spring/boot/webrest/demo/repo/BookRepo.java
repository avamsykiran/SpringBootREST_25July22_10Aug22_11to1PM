package com.cts.spring.boot.webrest.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.spring.boot.webrest.demo.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity,Long> {

}
