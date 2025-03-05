package com.example.spring.repeat.controller;

import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.CityResponse;
import com.example.spring.repeat.service.abstraction.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/{id}")
    public CityResponse getCity(@PathVariable String id) {
        return cityService.getCity(id);
    }

    @PostMapping("/save-region")
    public void addRegionToCity(@RequestBody RegionRequest region) {
        cityService.addRegionToCity(region);
    }
}
