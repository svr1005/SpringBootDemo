package com.svr.SpringBootDemo.Vehicle;

import com.svr.SpringBootDemo.Engine.Engine;
import com.svr.SpringBootDemo.GPS.Gps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {


    /* Field injection */
//    Very bad for testing purposes, can't test
//    @Autowired
//    @Qualifier("petrolEngine")
//    private Engine engine;

    /* Setter injection */
//    Used for optional dependencies which you may or may not want to be created
//    Has lazy initiallisation (gets injected only when method is called)
//    Medium for testing
//    private Engine engine;
//
//    @Autowired
//    @Qualifier("petrolEngine")
//    void setEngine(Engine engine)
//    {
//        this.engine = engine;
//    }

    /* Constructor injection */
//    Very good for testing, No extra effort required while testing
//    very good for clear communication
    private final Engine engine;

    @Autowired
    public Car(@Qualifier("petrolEngine")Engine engine) {
        this.engine = engine;
    }

    private Gps gps;
    // This makes sure that the dependency is not required,
    // We didn't even made the GPS class as Bean because we didn't put @Component annotation in the code
    @Autowired(required = false)
    void setGPS(Gps gps) {
        this.gps = gps;
    }

    public void drive() {
        engine.start();
        System.out.println("Car is moving");
    }
}
