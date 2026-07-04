package com.svr.SpringBootDemo.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseService {

    @Autowired
    private CounterService counterService1;

    @Autowired
    private CounterService counterService2;

    public DatabaseService() {
        System.out.println("Constructor called");
    }

    @PostConstruct
    public void pehle() {
        counterService1.increment();
        counterService1.increment();
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void baadMein() {
        System.out.println(counterService1.getCount());
        System.out.println(counterService2.getCount());
        System.out.println("@PreDestroy");
    }
}
