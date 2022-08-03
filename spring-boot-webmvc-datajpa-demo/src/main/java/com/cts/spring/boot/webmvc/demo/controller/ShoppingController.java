package com.cts.spring.boot.webmvc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.spring.boot.webmvc.demo.entity.BookEntity;

@Controller
@RequestMapping("/cart")
public class ShoppingController {

	@Autowired
	@Qualifier("shoppingCart")
	private List<BookEntity> shoppingCart;
	
	@GetMapping("/show")
	public ModelAndView getCartAction() {
		return new ModelAndView("cart/list-page", "cart", shoppingCart);
	}
	
	@GetMapping("/remove")
	public ModelAndView removeFromCartAction(@RequestParam("bc")Long bookCode) {
		shoppingCart.remove(shoppingCart.stream().filter(b -> b.getBookCode()==bookCode).findFirst().orElse(null));
		return new ModelAndView("cart/list-page", "cart", shoppingCart);
	}
}
