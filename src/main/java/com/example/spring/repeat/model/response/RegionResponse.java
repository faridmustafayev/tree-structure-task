package com.example.spring.repeat.model.response;

import com.example.spring.repeat.dao.entity.DivisionEntity;
import com.example.spring.repeat.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegionResponse {
    private String id;
    private String name;
    private String address;
    private String cityWhichItBelongs;
    private Status status;
    private List<DivisionEntity> divisions = new ArrayList<>();
}
