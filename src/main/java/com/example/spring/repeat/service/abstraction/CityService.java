package com.example.spring.repeat.service.abstraction;

import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.CityResponse;

public interface CityService {
    void saveCity(PoliceStationEntity policeStation, CityRequest city);
    CityResponse getCity(String id);
    void addRegionToCity(RegionRequest region);
}
