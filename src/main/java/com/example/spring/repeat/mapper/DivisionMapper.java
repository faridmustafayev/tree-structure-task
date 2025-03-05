package com.example.spring.repeat.mapper;

import com.example.spring.repeat.dao.entity.DivisionEntity;
import com.example.spring.repeat.dao.entity.RegionEntity;
import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.response.DivisionResponse;

import java.util.UUID;

import static com.example.spring.repeat.model.enums.Status.ACTIVE;

public enum DivisionMapper {
    DIVISION_MAPPER;

    public DivisionEntity buildDivisionEntity(RegionEntity region, DivisionRequest request) {
        var id = UUID.randomUUID().toString();
        return DivisionEntity.builder()
                .id(id)
                .status(ACTIVE)
                .regionWhichItBelongs(request.getRegionWhichItBelongs())
                .region(region)
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }

    public DivisionResponse buildDivisionResponse(DivisionEntity division) {
        return DivisionResponse.builder()
                .id(division.getId())
                .name(division.getName())
                .status(division.getStatus())
                .regionWhichItBelongs(division.getRegionWhichItBelongs())
                .address(division.getAddress())
                .build();
    }
}
