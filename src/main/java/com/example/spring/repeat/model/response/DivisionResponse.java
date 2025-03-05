package com.example.spring.repeat.model.response;

import com.example.spring.repeat.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DivisionResponse {
    private String id;
    private String name;
    private String address;
    private Status status;
    private String regionWhichItBelongs;
}
