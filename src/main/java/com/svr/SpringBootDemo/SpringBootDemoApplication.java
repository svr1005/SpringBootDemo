package com.svr.SpringBootDemo;

import com.svr.SpringBootDemo.CircularDependency.Student;
import com.svr.SpringBootDemo.CircularDependency.Teacher;
import com.svr.SpringBootDemo.Engine.ElectricEngine;
import com.svr.SpringBootDemo.Engine.Engine;
import com.svr.SpringBootDemo.Engine.PetrolEngine;
import com.svr.SpringBootDemo.Vehicle.Bus;
import com.svr.SpringBootDemo.Vehicle.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.lang.module.Configuration;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
         ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

        Student s1 = context.getBean(Student.class);
        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);
        List<Student> list = Arrays.asList(s1, s2, s3);
        Teacher t = context.getBean(Teacher.class);
        t.listOfStudents();

//        Engine petrol = new PetrolEngine();
//        Engine electric = new ElectricEngine();
//
//        Car car = new Car(petrol);
//        Bus bus  = new Bus(electric);
//        car.drive();
//        bus .drive();

        Car car = context.getBean(Car.class);
        Bus bus = context.getBean(Bus.class);
        bus.drive();

    }
}
