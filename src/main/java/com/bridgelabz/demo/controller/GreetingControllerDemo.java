package com.bridgelabz.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.Greeting;

@RestController
@RequestMapping("/greetingapp")
public class GreetingControllerDemo {
		
		//String template for generating greeting message
	    public static final String template = "Hello, %s !";

	    //AtomicLong object for counter increment
	    private final AtomicLong counter = new AtomicLong();

	    //Mapping greeting with URL to generate the Bean Response in JSON Format
	    @GetMapping("/greeting")
	    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name) {
	        return new Greeting(counter.incrementAndGet(),
	                String.format(template, name));
	    }
	}

