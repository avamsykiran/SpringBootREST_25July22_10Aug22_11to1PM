package com.cts.spring.boot.webrest.demo.service;

import java.util.List;

import com.cts.spring.boot.webrest.demo.entity.BookEntity;
import com.cts.spring.boot.webrest.demo.exception.OperationFailedException;

public interface BookService {
	List<BookEntity> getAll();
	BookEntity getById(Long bookCode);
	void delete(Long bookCode);
	BookEntity add(BookEntity book) throws OperationFailedException;
	BookEntity replace(BookEntity book)throws OperationFailedException;
}
