package com.example.spring.repeat.controller;

import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.response.RegionResponse;
import com.example.spring.repeat.service.abstraction.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/regions")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/{id}")
    public RegionResponse getRegion(@PathVariable String id) {
        return regionService.getRegion(id);
    }

    @PostMapping
    public void addDivisionToRegion(@RequestBody DivisionRequest division) {
        regionService.addDivisionToRegion(division);
    }

    @PutMapping("/{regionId}")
    public void moveRegionToAnotherCity(@PathVariable String regionId, @RequestParam String currentCityId, @RequestParam String nextCityId) {
        regionService.moveRegionToAnotherCity(regionId, currentCityId, nextCityId);
    }
}
