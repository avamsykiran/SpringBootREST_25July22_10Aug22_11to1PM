package com.cts.spring.boot.webmvc.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.spring.boot.webmvc.demo.entity.BookEntity;
import com.cts.spring.boot.webmvc.demo.exception.OperationFailedException;
import com.cts.spring.boot.webmvc.demo.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<BookEntity> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public BookEntity getById(Long bookCode) {
		return bookRepo.findById(bookCode).orElse(null);
	}

	@Override
	public void delete(Long bookCode) {
		bookRepo.deleteById(bookCode);
	}

	@Override
	public BookEntity add(BookEntity book) throws OperationFailedException {
		if(book==null) 
			throw new OperationFailedException("no book received");
		
		if( book.getBookCode()!=null)
			throw new OperationFailedException("Book Code expected to be empty as it is system generated");
		
		return bookRepo.save(book);
	}

	@Override
	public BookEntity replace(BookEntity book) throws OperationFailedException {
		if(book==null) 
			throw new OperationFailedException("no book received");
		
		if(!bookRepo.existsById(book.getBookCode()))
			throw new OperationFailedException("no such book found");
		
		return bookRepo.save(book);
	}

}
