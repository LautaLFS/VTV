package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.ObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<ObservationEntity, String> {
}
