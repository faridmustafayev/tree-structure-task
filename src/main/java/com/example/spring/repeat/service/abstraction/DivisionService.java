package com.example.spring.repeat.service.abstraction;

import com.example.spring.repeat.dao.entity.RegionEntity;
import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.response.DivisionResponse;

public interface DivisionService {
    void saveDivision(RegionEntity region, DivisionRequest division);
    DivisionResponse getDivision(String id);
    void moveDivisionToAnotherRegion(String divisionId, String currentRegionId, String nextRegionId);
}
