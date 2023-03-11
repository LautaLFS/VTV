package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.InspectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InspectionRepository extends JpaRepository<InspectionEntity, String> {
    @Query("SELECT a FROM InspectionEntity a WHERE a.state = :state")
    List<InspectionEntity> findByState(@Param("state")String state);

    Optional<InspectionEntity> findByVehicleId(String id);
}
