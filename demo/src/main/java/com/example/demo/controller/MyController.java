package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.annonation.EnableLoggTracer;

@RestController
@PropertySource( value = { "author.properties" })
public class MyController {
	
	private static final Logger Logger = LoggerFactory.getLogger(MyController.class) ;
	
	@Value("${author.name}")
	private String s ;
	@Value("${author.age}")
	private String age;
	
	@Value("${spring.application.name}")
	private String app;
	@GetMapping("/auth")
	@EnableLoggTracer(name = "Ram")
	public String getAuthor() {
		
		
		return app+s+age;
	}

}
