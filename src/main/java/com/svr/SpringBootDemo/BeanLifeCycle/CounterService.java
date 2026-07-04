package com.svr.SpringBootDemo.BeanLifeCycle;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") //Creates a new Bean everytime
public class CounterService {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
    }
}
