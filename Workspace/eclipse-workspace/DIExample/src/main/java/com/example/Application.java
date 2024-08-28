package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfiguration.class);
		ConstructorBased constructorBased=applicationContext.getBean(ConstructorBased.class);
		constructorBased.receiving("This is from C");
	}
}
