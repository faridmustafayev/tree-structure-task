package com.example.spring.repeat.model.response;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliceStationResponse {
    private String id;
    private String name;
    private String address;
    private Status status;
    private List<CityEntity> cities = new ArrayList<>();
}
