package com.example.spring.repeat.controller;

import com.example.spring.repeat.model.response.DivisionResponse;
import com.example.spring.repeat.service.abstraction.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/divisions")
@RequiredArgsConstructor
public class DivisionController {
    private final DivisionService divisionService;

    @GetMapping("/{id}")
    public DivisionResponse getDivision(@PathVariable String id) {
        return divisionService.getDivision(id);
    }

    @PutMapping("/{divisionId}")
    public void moveDivisionToAnotherRegion(@PathVariable String divisionId, @RequestParam String currentRegionId, @RequestParam String nextRegionId) {
        divisionService.moveDivisionToAnotherRegion(divisionId, currentRegionId, nextRegionId);
    }
}
