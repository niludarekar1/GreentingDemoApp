package com.demo.service;

import com.demo.model.Greeting;
import com.demo.model.User;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(User userDto);
}