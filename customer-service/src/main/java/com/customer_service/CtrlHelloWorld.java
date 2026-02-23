package com.customer_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class CtrlHelloWorld {

	@GetMapping
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping("/otro")
	public String helloWorld2() {
		return "Hello World 2";
	}

}
