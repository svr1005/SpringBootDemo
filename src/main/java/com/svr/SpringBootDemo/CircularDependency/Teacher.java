package com.svr.SpringBootDemo.CircularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Teacher {

    private final List<Student> students;

    @Autowired
    public Teacher(@Lazy List<Student> students) {
        this.students = students;
        System.out.println("Student is Injected");
    }

    public void listOfStudents()
    {
        students.forEach(System.out::println);
    }
}
