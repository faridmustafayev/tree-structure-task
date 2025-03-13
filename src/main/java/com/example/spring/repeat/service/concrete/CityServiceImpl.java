package com.example.spring.repeat.service.concrete;

import com.example.spring.repeat.dao.entity.CityEntity;
import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import com.example.spring.repeat.dao.repository.CityRepository;
import com.example.spring.repeat.dao.repository.PoliceStationRepository;
import com.example.spring.repeat.exception.NotFoundException;
import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.request.RegionRequest;
import com.example.spring.repeat.model.response.CityResponse;
import com.example.spring.repeat.service.abstraction.CityService;
import com.example.spring.repeat.service.abstraction.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.spring.repeat.exception.ExceptionConstants.CITY_NOT_FOUND;
import static com.example.spring.repeat.exception.ExceptionConstants.POLICE_STATION_NOT_FOUND;
import static com.example.spring.repeat.mapper.CityMapper.CITY_MAPPER;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final PoliceStationRepository policeStationRepository;
    private final RegionService regionService;

    @Override
    public void saveCity(PoliceStationEntity policeStation, CityRequest city) {
        var cityEntity = CITY_MAPPER.buildCityEntity(policeStation, city);

        if (cityEntity.getPoliceStationWhichItBelongs() != null) {
            var police = policeStationRepository.findById(cityEntity.getPoliceStationWhichItBelongs())
                    .orElseThrow(() -> new NotFoundException(POLICE_STATION_NOT_FOUND.getCode(), POLICE_STATION_NOT_FOUND.getMessage(policeStation.getId())));
            cityEntity.setPolice(police);
        }

        cityRepository.save(cityEntity);
    }

    @Override
    public CityResponse getCity(String id) {
        var cityEntity = fetChCityIfExist(id);
        return CITY_MAPPER.buildCityResponse(cityEntity);
    }

    @Override
    public void addRegionToCity(RegionRequest region) {
        var cityEntity = fetChCityIfExist(region.getCityWhichItBelongs());
        regionService.saveRegion(cityEntity, region);
    }

    private CityEntity fetChCityIfExist(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(CITY_NOT_FOUND.getCode(), CITY_NOT_FOUND.getMessage(id)));
    }
}
