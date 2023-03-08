package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.InspectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectorRepository extends JpaRepository<InspectorEntity, String> {
}
