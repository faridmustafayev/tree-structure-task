package com.example.spring.repeat.dao.repository;

import com.example.spring.repeat.dao.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, String> {
}
