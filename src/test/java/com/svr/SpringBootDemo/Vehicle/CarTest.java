package com.svr.SpringBootDemo.Vehicle;

import com.svr.SpringBootDemo.Engine.Engine;
import com.svr.SpringBootDemo.Engine.PetrolEngine;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void carDriveTest() {
//        Car car = new Car();
//        Engine engine = new PetrolEngine();
//        car.setEngine(engine);
//        car.drive();
        Car car = new Car(new PetrolEngine());
        car.drive();
    }
}
