package com.example.spring.repeat.service.concrete;

import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import com.example.spring.repeat.dao.repository.PoliceStationRepository;
import com.example.spring.repeat.exception.NotFoundException;
import com.example.spring.repeat.model.request.CityRequest;
import com.example.spring.repeat.model.request.PoliceStationRequest;
import com.example.spring.repeat.model.response.PoliceStationResponse;
import com.example.spring.repeat.service.abstraction.CityService;
import com.example.spring.repeat.service.abstraction.PoliceStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.spring.repeat.exception.ExceptionConstants.POLICE_STATION_NOT_FOUND;
import static com.example.spring.repeat.mapper.PoliceStationMapper.POLICE_STATION_MAPPER;

@Service
@RequiredArgsConstructor
public class PoliceStationServiceImpl implements PoliceStationService {
    private final PoliceStationRepository policeStationRepository;
    private final CityService cityService;

    @Override
    public void savePoliceStation(PoliceStationRequest police) {
        var policeEntity = POLICE_STATION_MAPPER.buildPoliceStationEntity(police);
        policeStationRepository.save(policeEntity);
    }

    @Override
    public PoliceStationResponse getPoliceStation(String id) {
        var policeStation = fetchPoliceIfExist(id);
        return POLICE_STATION_MAPPER.buildPoliceStationResponse(policeStation);
    }

    @Override
    public void addCityToPoliceStation(CityRequest city) {
        var police = fetchPoliceIfExist(city.getPoliceStationWhichItBelongs());
        cityService.saveCity(police, city);
    }

    private PoliceStationEntity fetchPoliceIfExist(String id) {
        return policeStationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(POLICE_STATION_NOT_FOUND.getCode(), POLICE_STATION_NOT_FOUND.getMessage(id)));
    }
}
