package com.example.spring.repeat.controller;

import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.request.PoliceStationRequest;
import com.example.spring.repeat.model.response.PoliceStationResponse;
import com.example.spring.repeat.service.abstraction.PoliceStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("v1/polices")
@RequiredArgsConstructor
public class PoliceStationController {
    private final PoliceStationService policeStationService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void savePoliceStation(@RequestBody PoliceStationRequest police) {
        policeStationService.savePoliceStation(police);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public PoliceStationResponse getPoliceStation(@PathVariable String id) {
        return policeStationService.getPoliceStation(id);
    }

    @PostMapping("/save-city")
    public void addCityToPoliceStation(@RequestBody CityRequest city) {
        policeStationService.addCityToPoliceStation(city);
    }
}
