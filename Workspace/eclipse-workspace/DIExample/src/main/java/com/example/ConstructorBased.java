package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ConstructorBased {
	private Message message;
	@Autowired
	
	public ConstructorBased(@Qualifier ("C") Message message) {
		super();
		this.message=message;
	}
	
	public void receiving(String message) {
		this.message.sendings(message);
	}
}
