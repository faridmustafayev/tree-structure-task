package com.example.spring.repeat.mapper;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.response.CityResponse;

import java.util.UUID;

import static com.example.spring.repeat.model.enums.Status.ACTIVE;

public enum CityMapper {
    CITY_MAPPER;

    public CityEntity buildCityEntity(PoliceStationEntity policeStation, CityRequest city) {
        var id = UUID.randomUUID().toString();
        return CityEntity.builder()
                .id(id)
                .policeStationWhichItBelongs(city.getPoliceStationWhichItBelongs())
                .police(policeStation)
                .status(ACTIVE)
                .name(city.getName())
                .address(city.getAddress())
                .build();
    }

    public CityResponse buildCityResponse(CityEntity city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .status(city.getStatus())
                .policeStationWhichItBelongs(city.getPoliceStationWhichItBelongs())
                .address(city.getAddress())
                .regions(city.getRegions())
                .build();
    }
}
