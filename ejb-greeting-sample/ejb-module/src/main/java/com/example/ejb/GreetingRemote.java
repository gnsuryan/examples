package com.example.ejb;

import javax.ejb.Remote;

@Remote
public interface GreetingRemote {
    String sayHello(String name);
}
