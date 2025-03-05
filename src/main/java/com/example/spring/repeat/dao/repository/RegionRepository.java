package com.example.spring.repeat.dao.repository;

import com.example.spring.repeat.dao.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<RegionEntity, String> {
}
