package com.example.spring.repeat.mapper;

import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import com.example.spring.repeat.model.request.PoliceStationRequest;
import com.example.spring.repeat.model.response.PoliceStationResponse;

import java.util.UUID;

import static com.example.spring.repeat.model.enums.Status.ACTIVE;

public enum PoliceStationMapper {
    POLICE_STATION_MAPPER;

    public PoliceStationEntity buildPoliceStationEntity(PoliceStationRequest police) {
        var id = UUID.randomUUID().toString();
        return PoliceStationEntity.builder()
                .id(id)
                .name(police.getName())
                .status(ACTIVE)
                .address(police.getAddress())
                .build();
    }

    public PoliceStationResponse buildPoliceStationResponse(PoliceStationEntity police) {
        return PoliceStationResponse.builder()
                .id(police.getId())
                .name(police.getName())
                .status(police.getStatus())
                .address(police.getAddress())
                .cities(police.getCities())
                .build();
    }
}
