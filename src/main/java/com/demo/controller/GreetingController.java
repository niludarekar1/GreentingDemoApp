package com.demo.controller;

import com.demo.dto.UserDto;
import com.demo.model.Greeting;
import com.demo.model.User;
import com.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetingapp")
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;

    @GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();
    }

    @PostMapping("/search")
    public String greetingMessage(@RequestBody User user) {
        return greetingService.greetingMessageByName(user);
    }
}