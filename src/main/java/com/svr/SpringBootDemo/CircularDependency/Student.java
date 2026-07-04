package com.svr.SpringBootDemo.CircularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private final Teacher teacher;

    @Autowired
    public Student(Teacher teacher) {
        this.teacher = teacher;
        System.out.println("Teacher is Injected");
    }
}
