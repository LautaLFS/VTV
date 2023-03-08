package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.InspectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<InspectionEntity, String> {
}
