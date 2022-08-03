package com.cts.spring.boot.webmvc.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.boot.webmvc.demo.entity.BookEntity;
import com.cts.spring.boot.webmvc.demo.exception.OperationFailedException;
import com.cts.spring.boot.webmvc.demo.service.BookService;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private BookService bookService;

	@Autowired
	@Qualifier("shoppingCart")
	private List<BookEntity> shoppingCart;
	
	@GetMapping("/list")
	public ModelAndView getAllBooksAction() {
		return new ModelAndView("books/books-list-page", "books", bookService.getAll());
	}

	@GetMapping("/delete")
	public String deleteBookAction(@RequestParam("bc") long bookCode) {
		bookService.delete(bookCode);
		return "redirect:/books/list";
	}

	@GetMapping("/add")
	public ModelAndView addBookAction() {
		return new ModelAndView("books/book-form-page", "book", new BookEntity());
	}

	@GetMapping("/edit")
	public ModelAndView editBookAction(@RequestParam("bc") Long bookCode) {
		return new ModelAndView("books/book-form-page", "book", bookService.getById(bookCode));
	}

	@PostMapping({ "/add", "/edit" })
	public ModelAndView saveBookAction(@ModelAttribute("book") @Valid BookEntity book, BindingResult bindingResult,
			HttpServletRequest req) throws OperationFailedException {
		ModelAndView mv = null;

		if (bindingResult.hasErrors()) {
			mv = new ModelAndView("books/book-form-page", "book", book);
		} else {
			if (req.getServletPath().endsWith("/add")) {
				bookService.add(book);
			} else {
				bookService.replace(book);
			}
			mv = new ModelAndView("redirect:/books/list");
		}

		return mv;
	}

	@GetMapping("/select")
	public String addBookToCartAction(@RequestParam("bc") long bookCode) {
		shoppingCart.add(bookService.getById(bookCode));
		return "redirect:/books/list";
	}	
}
