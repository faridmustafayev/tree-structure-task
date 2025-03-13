package com.example.spring.repeat.dao.repository;

import com.example.spring.repeat.dao.entity.DivisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<DivisionEntity, String> {
}
