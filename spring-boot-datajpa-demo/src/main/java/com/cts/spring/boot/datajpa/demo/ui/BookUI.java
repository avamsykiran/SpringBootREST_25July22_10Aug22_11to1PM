package com.cts.spring.boot.datajpa.demo.ui;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cts.spring.boot.datajpa.demo.entity.Book;
import com.cts.spring.boot.datajpa.demo.exception.OperationFailedException;
import com.cts.spring.boot.datajpa.demo.service.BookService;

@Component
public class BookUI implements CommandLineRunner {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private Scanner kbin;

	private void doList() {
		List<Book> books = bookService.getAll();
		
		if(books.isEmpty()) {
			System.out.println("No Records Yet");
		}else {
			books.stream().forEach(System.out::println);
		}
	}
	
	private void doAdd() {
		Book book = new Book();
		System.out.print("Title: ");
		book.setTitle(kbin.next());
		System.out.print("Price: ");
		book.setPrice(kbin.nextDouble());
		System.out.print("Publish Date(yyyy-MM-dd): ");
		book.setPublishDate(LocalDate.parse(kbin.next()));
		
		try {
			book = bookService.add(book);
			System.out.println("Book got saved with id: "+book.getBookCode());
		} catch (OperationFailedException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void doRemove() {
		System.out.print("Book Code: ");
		long bookCode = kbin.nextLong();
		bookService.delete(bookCode);
	}
	
	enum Menu {
		ADD,LIST,REMOVE,QUIT;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Menu menu = null;
		Menu[] menus = Menu.values();
		String regExp = Arrays.stream(menus).map(Menu::toString).reduce((m1,m2) -> m1+"|"+m2).orElse("");
		while(menu!=Menu.QUIT) {	
			System.out.print("Choice["+regExp+"]:> ");
			String ch = kbin.next().toUpperCase();
			
			if(!ch.matches(regExp)) {
				System.err.println("Invalid Choice");
				continue;
			}
			
			menu = Menu.valueOf(ch);
			
			switch(menu) {
			case ADD:doAdd(); break;
			case LIST:doList();break;
			case REMOVE:doRemove();break;
			case QUIT:System.out.println("App Terminated"); break;
			}
		}
	}
}

