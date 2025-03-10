package com.example.ejb;

import jakarta.ejb.Remote;

@Remote
public interface GreetingRemote {
    String sayHello(String name);
}
