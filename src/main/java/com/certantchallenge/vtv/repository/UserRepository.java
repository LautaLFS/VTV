package com.certantchallenge.vtv.repository;

import com.certantchallenge.vtv.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByName(String username);
}
