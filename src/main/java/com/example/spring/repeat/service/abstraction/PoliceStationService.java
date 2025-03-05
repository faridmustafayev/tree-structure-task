package com.example.spring.repeat.service.abstraction;

import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.request.PoliceStationRequest;
import com.example.spring.repeat.model.response.PoliceStationResponse;

public interface PoliceStationService {
    void savePoliceStation(PoliceStationRequest police);
    PoliceStationResponse getPoliceStation(String id);
    void addCityToPoliceStation(CityRequest city);
}
