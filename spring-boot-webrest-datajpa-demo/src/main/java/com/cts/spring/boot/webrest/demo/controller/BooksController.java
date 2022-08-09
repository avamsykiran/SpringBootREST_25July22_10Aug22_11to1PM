package com.cts.spring.boot.webrest.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.spring.boot.webrest.demo.entity.BookEntity;
import com.cts.spring.boot.webrest.demo.exception.OperationFailedException;
import com.cts.spring.boot.webrest.demo.service.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<BookEntity>> getAllBooksAction() {
		return new ResponseEntity<>(bookService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{bc:[0-9]{1,5}}")
	public ResponseEntity<BookEntity> getBookAction(@PathVariable("bc") long bookCode) {
		BookEntity b = bookService.getById(bookCode);
		return b==null?new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<BookEntity>(b, HttpStatus.OK);
	}
	
	@GetMapping("/{ts:\\D+}")
	public ResponseEntity<List<BookEntity>> getAllBookByTitleStubAction(@PathVariable("ts") String titleStub) {
		return new ResponseEntity<>(bookService.getAllThatHasTitle(titleStub),HttpStatus.OK);
	}
	
	@DeleteMapping("/{bc}")
	public ResponseEntity<Void> deleteBookAction(@PathVariable("bc") long bookCode) {
		bookService.delete(bookCode);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
	public ResponseEntity<BookEntity> saveBookAction(@RequestBody @Valid BookEntity book, BindingResult bindingResult,
			HttpServletRequest req) throws OperationFailedException {
		
		ResponseEntity<BookEntity> resp=null;

		if (bindingResult.hasErrors()) {
			throw new OperationFailedException(bindingResult.getAllErrors().stream().map(err -> err.getDefaultMessage()).reduce((s1,s2)->s1+","+s2).orElse(""));
		} else {
			if ("POST".equalsIgnoreCase(req.getMethod())) {
				resp = new ResponseEntity<>(bookService.add(book), HttpStatus.CREATED);
			} else {
				resp = new ResponseEntity<>(bookService.replace(book), HttpStatus.ACCEPTED);
			}
		}

		return resp;
	}
}
