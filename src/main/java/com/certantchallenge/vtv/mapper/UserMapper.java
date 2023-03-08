package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper extends ModelMapper {
    public UserDTO toDto(UserEntity userEntity){
        return map(userEntity, UserDTO.class);
    }
    public UserEntity toEntity(UserDTO userDTO){
        return map(userDTO, UserEntity.class);
    }
}
