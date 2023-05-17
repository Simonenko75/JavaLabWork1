package com.example.LabWork1.repository;

import com.example.LabWork1.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> findByAgeGreaterThan(int age);
}
