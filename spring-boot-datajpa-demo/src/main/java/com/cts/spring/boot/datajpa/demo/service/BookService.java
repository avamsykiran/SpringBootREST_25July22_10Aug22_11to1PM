package com.cts.spring.boot.datajpa.demo.service;

import java.util.List;

import com.cts.spring.boot.datajpa.demo.entity.Book;
import com.cts.spring.boot.datajpa.demo.exception.OperationFailedException;

public interface BookService {
	List<Book> getAll();
	Book getById(Long bookCode);
	void delete(Long bookCode);
	Book add(Book book) throws OperationFailedException;
	Book replace(Book book)throws OperationFailedException;
}
