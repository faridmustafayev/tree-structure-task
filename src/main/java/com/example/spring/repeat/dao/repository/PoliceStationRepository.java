package com.example.spring.repeat.dao.repository;

import com.example.spring.repeat.dao.entity.PoliceStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliceStationRepository extends JpaRepository<PoliceStationEntity, String> {
}
