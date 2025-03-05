package com.example.spring.repeat.mapper;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.dao.entity.RegionEntity;
import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.RegionResponse;

import java.util.UUID;

import static com.example.spring.repeat.model.enums.Status.ACTIVE;

public enum RegionMapper {
    REGION_MAPPER;

    public RegionEntity buildRegionEntity(CityEntity city, RegionRequest region) {
        var id = UUID.randomUUID().toString();
        return RegionEntity.builder()
                .id(id)
                .status(ACTIVE)
                .cityWhichItBelongs(region.getCityWhichItBelongs())
                .name(region.getName())
                .address(region.getAddress())
                .city(city)
                .build();
    }

    public RegionResponse buildRegionResponse(RegionEntity region) {
        return RegionResponse.builder()
                .id(region.getId())
                .name(region.getName())
                .status(region.getStatus())
                .address(region.getAddress())
                .cityWhichItBelongs(region.getCityWhichItBelongs())
                .divisions(region.getDivisions())
                .build();
    }
}
