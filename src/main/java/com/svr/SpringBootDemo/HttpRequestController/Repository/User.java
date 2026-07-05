package com.svr.SpringBootDemo.HttpRequestController.Repository;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}
