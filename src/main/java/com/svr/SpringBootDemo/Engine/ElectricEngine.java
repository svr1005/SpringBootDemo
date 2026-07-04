package com.svr.SpringBootDemo.Engine;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary //Overrides it
public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Electric engine is started");
    }
}
