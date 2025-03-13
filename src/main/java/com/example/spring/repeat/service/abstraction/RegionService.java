package com.example.spring.repeat.service.abstraction;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.RegionResponse;

public interface RegionService {
    void saveRegion(CityEntity city, RegionRequest region);
    RegionResponse getRegion(String id);
    void addDivisionToRegion(DivisionRequest division);
    void moveRegionToAnotherCity(String regionId, String currentCityId, String nextCityId);
}
