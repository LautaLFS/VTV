package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.StickerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<StickerEntity, String> {
}
