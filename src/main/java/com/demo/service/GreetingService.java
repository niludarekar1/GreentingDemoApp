package com.demo.service;

import com.demo.dto.UserDto;
import com.demo.model.Greeting;
import com.demo.model.User;
import com.demo.repositoy.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService{
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository iGreetingRepository;

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }
    @Override
    public String greetingMessageByName(User user1) {
        User user = new User();
        iGreetingRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
}
