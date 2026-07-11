package com.svr.SpringBootDemo.HttpRequestController.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserRequest {
        private int id;
        private String name;
        private int yearsOld;
}
