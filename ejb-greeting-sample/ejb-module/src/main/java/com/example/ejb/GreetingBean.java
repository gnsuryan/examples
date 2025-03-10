package com.example.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class GreetingBean implements GreetingRemote {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + "! Welcome to WebLogic EJB 3.0.";
    }
}
