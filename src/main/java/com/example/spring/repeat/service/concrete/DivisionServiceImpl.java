package com.example.spring.repeat.service.concrete;

import com.example.spring.repeat.dao.entity.DivisionEntity;
import com.example.spring.repeat.dao.entity.RegionEntity;
import com.example.spring.repeat.dao.repository.DivisionRepository;
import com.example.spring.repeat.dao.repository.RegionRepository;
import com.example.spring.repeat.exception.NotFoundException;
import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.response.DivisionResponse;
import com.example.spring.repeat.service.abstraction.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.spring.repeat.exception.ExceptionConstants.DIVISION_NOT_FOUND;
import static com.example.spring.repeat.exception.ExceptionConstants.REGION_NOT_FOUND;
import static com.example.spring.repeat.mapper.DivisionMapper.DIVISION_MAPPER;
import static com.example.spring.repeat.model.enums.Status.IN_PROGRESS;


@Service
@RequiredArgsConstructor
public class DivisionServiceImpl implements DivisionService {
    private final DivisionRepository divisionRepository;
    private final RegionRepository regionRepository;

    @Override
    public void saveDivision(RegionEntity region, DivisionRequest division) {
        var divisionEntity = DIVISION_MAPPER.buildDivisionEntity(region, division);

        if (divisionEntity.getRegionWhichItBelongs() != null) {
            var regionEntity = regionRepository.findById(divisionEntity.getRegionWhichItBelongs())
                    .orElseThrow(() -> new NotFoundException(REGION_NOT_FOUND.getCode(), REGION_NOT_FOUND.getMessage()));
            divisionEntity.setRegion(regionEntity);
        }

        divisionRepository.save(divisionEntity);
    }

    @Override
    public DivisionResponse getDivision(String id) {
        var division = fetchDivisionIfExist(id);
        return DIVISION_MAPPER.buildDivisionResponse(division);
    }

    @Override
    public void moveDivisionToAnotherRegion(String divisionId, String currentRegionId, String nextRegionId) {
        var currentRegionEntity = regionRepository.findById(currentRegionId)
                .orElseThrow(() -> new NotFoundException(REGION_NOT_FOUND.getCode(), REGION_NOT_FOUND.getMessage(currentRegionId)));
        var nextRegionEntity = regionRepository.findById(nextRegionId)
                .orElseThrow(() -> new NotFoundException(REGION_NOT_FOUND.getCode(), REGION_NOT_FOUND.getMessage(nextRegionId)));

        var divisionToMove = currentRegionEntity.getDivisions().stream()
                .filter(division -> division.getId().equals(divisionId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(DIVISION_NOT_FOUND.getCode(), DIVISION_NOT_FOUND.getMessage(divisionId)));

        divisionToMove.setRegion(nextRegionEntity);
        divisionToMove.setStatus(IN_PROGRESS);

        divisionRepository.save(divisionToMove);
        regionRepository.save(nextRegionEntity);
    }

    private DivisionEntity fetchDivisionIfExist(String id) {
        return divisionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DIVISION_NOT_FOUND.getCode(), DIVISION_NOT_FOUND.getMessage(id)));
    }
}
