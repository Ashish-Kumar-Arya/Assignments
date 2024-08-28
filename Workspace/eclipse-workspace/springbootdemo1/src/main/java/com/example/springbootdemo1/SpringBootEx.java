package com.example.springbootdemo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBootEx {
	@RequestMapping("/")	
	public int display() {
		return 1;
	}
}
