package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, String> {
}
