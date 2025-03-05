package com.example.spring.repeat.service.concrete;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.dao.entity.DivisionEntity;
import com.example.spring.repeat.dao.entity.RegionEntity;
import com.example.spring.repeat.dao.repository.CityRepository;
import com.example.spring.repeat.dao.repository.RegionRepository;
import com.example.spring.repeat.exception.NotFoundException;
import com.example.spring.repeat.model.request.DivisionRequest;
import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.RegionResponse;
import com.example.spring.repeat.service.abstraction.DivisionService;
import com.example.spring.repeat.service.abstraction.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.spring.repeat.exception.ExceptionConstants.CITY_NOT_FOUND;
import static com.example.spring.repeat.exception.ExceptionConstants.REGION_NOT_FOUND;
import static com.example.spring.repeat.mapper.RegionMapper.REGION_MAPPER;
import static com.example.spring.repeat.model.enums.Status.IN_PROGRESS;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;
    private final CityRepository cityRepository;
    private final DivisionService divisionService;

    @Override
    public void saveRegion(CityEntity city, RegionRequest region) {
        var regionEntity = REGION_MAPPER.buildRegionEntity(city, region);

        if (regionEntity.getCityWhichItBelongs() != null) {
            var cityEntity = cityRepository.findById(regionEntity.getCityWhichItBelongs())
                    .orElseThrow(() -> new NotFoundException(CITY_NOT_FOUND.getCode(), CITY_NOT_FOUND.getMessage(city.getId())));
            regionEntity.setCity(cityEntity);
        }

        regionRepository.save(regionEntity);
    }

    @Override
    public RegionResponse getRegion(String id) {
        var regionEntity = fetchRegionIfExist(id);
        return REGION_MAPPER.buildRegionResponse(regionEntity);
    }

    @Override
    public void addDivisionToRegion(DivisionRequest division) {
        var regionEntity = fetchRegionIfExist(division.getRegionWhichItBelongs());
        divisionService.saveDivision(regionEntity, division);
    }

    @Override
    public void moveRegionToAnotherCity(String regionId, String currentCityId, String nextCityId) {
        var currentCityEntity = cityRepository.findById(currentCityId)
                .orElseThrow(() -> new NotFoundException(CITY_NOT_FOUND.getCode(), CITY_NOT_FOUND.getMessage(currentCityId)));
        var nextCityEntity = cityRepository.findById(nextCityId)
                .orElseThrow(() -> new NotFoundException(CITY_NOT_FOUND.getCode(), CITY_NOT_FOUND.getMessage(nextCityId)));

        var regionToMove = currentCityEntity.getRegions().stream()
                .filter(region -> region.getId().equals(regionId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException(REGION_NOT_FOUND.getCode(), REGION_NOT_FOUND.getMessage(regionId)));

        regionToMove.setCity(nextCityEntity);
        regionToMove.setStatus(IN_PROGRESS);

        for (DivisionEntity division : regionToMove.getDivisions()) {
            division.setRegion(regionToMove);
        }

        regionRepository.save(regionToMove);
        cityRepository.save(nextCityEntity);

    }

    private RegionEntity fetchRegionIfExist(String id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(REGION_NOT_FOUND.getCode(), REGION_NOT_FOUND.getMessage(id)));
    }
}
