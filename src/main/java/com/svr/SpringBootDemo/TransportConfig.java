package com.svr.SpringBootDemo;

import com.svr.SpringBootDemo.Engine.PetrolEngine;
import com.svr.SpringBootDemo.Vehicle.Bus;
import com.svr.SpringBootDemo.Vehicle.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransportConfig {

    @Bean
    Bus bus() {
        return new Bus(new PetrolEngine());
    }
}
