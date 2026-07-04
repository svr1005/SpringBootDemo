package com.svr.SpringBootDemo.Vehicle;

import com.svr.SpringBootDemo.Engine.Engine;
import org.springframework.stereotype.Component;

@Component
public class Bus {

    private final Engine engine;

    public Bus(Engine engine) {
        this.engine = engine;
    }

    public void drive()
    {
        engine.start();
        System.out.println("Bus is moving");
    }
}
