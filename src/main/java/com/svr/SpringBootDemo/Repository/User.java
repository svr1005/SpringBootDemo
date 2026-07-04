package com.svr.SpringBootDemo.Repository;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Data
public class User {
    private UUID id;
    private String name;
    private int age;
}
