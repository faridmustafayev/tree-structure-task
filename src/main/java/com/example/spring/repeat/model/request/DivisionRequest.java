package com.example.spring.repeat.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DivisionRequest {
    private String name;
    private String address;
    private String regionWhichItBelongs;
}
