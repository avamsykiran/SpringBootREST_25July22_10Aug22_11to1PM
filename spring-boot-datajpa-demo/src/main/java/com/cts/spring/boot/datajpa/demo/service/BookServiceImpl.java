package com.cts.spring.boot.datajpa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.spring.boot.datajpa.demo.entity.Book;
import com.cts.spring.boot.datajpa.demo.exception.OperationFailedException;
import com.cts.spring.boot.datajpa.demo.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book getById(Long bookCode) {
		return bookRepo.findById(bookCode).orElse(null);
	}

	@Override
	public void delete(Long bookCode) {
		bookRepo.deleteById(bookCode);
	}

	@Override
	public Book add(Book book) throws OperationFailedException {
		if(book==null) 
			throw new OperationFailedException("no book received");
		
		if( book.getBookCode()!=null)
			throw new OperationFailedException("Book Code expected to be empty as it is system generated");
		
		return bookRepo.save(book);
	}

	@Override
	public Book replace(Book book) throws OperationFailedException {
		if(book==null) 
			throw new OperationFailedException("no book received");
		
		if(!bookRepo.existsById(book.getBookCode()))
			throw new OperationFailedException("no such book found");
		
		return bookRepo.save(book);
	}

}
