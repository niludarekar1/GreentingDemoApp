package com.bridgelabz.demo.controller;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.model.Greeting;
import com.bridgelabz.demo.model.User;

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
	    
	  
	    @RequestMapping("/user")
	    public Greeting greetingUser(@RequestParam(value="firstname", defaultValue = "Guest") String firstname,
	                             @RequestParam(value="lastname", defaultValue = "User") String lastname) {
	        return new Greeting(counter.incrementAndGet(),
	                String.format(template, (firstname+" "+lastname)));
	    }

	    @PutMapping("/{firstname}")
	    public Greeting greeting1(@PathVariable String firstname,
	                             @RequestParam(value = "lastname", defaultValue = "User") String lastname) {
	        return new Greeting(counter.incrementAndGet(),
	                String.format(template, (firstname+" "+lastname)));
	    }
	    
	    @PostMapping("/greeting")
	    public String greetingMessage(@RequestBody User user) {
			return "Hello" +user.getFirstName()+""+user.getLastName();
	    	
	    }

	}


