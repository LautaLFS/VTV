package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
}
