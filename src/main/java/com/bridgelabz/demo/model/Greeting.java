package com.bridgelabz.demo.model;

public class Greeting {
    long counter;
    String message;

    public Greeting(long counter, String message) {
        this.counter = counter;
        this.message = message;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}