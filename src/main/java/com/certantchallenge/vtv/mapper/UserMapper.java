package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.UserEntity;
import com.certantchallenge.vtv.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper extends ModelMapper {

    TypeMap<VehicleEntity, VehicleDTO> mapper = createTypeMap(VehicleEntity.class, VehicleDTO.class)
            .addMappings(mapping -> mapping.map( src -> src.getOwner().getName(),VehicleDTO::setOwner));
    public UserDTO toDto(UserEntity userEntity){
        return map(userEntity, UserDTO.class);
    }
    public UserEntity toEntity(UserDTO userDTO){
        return map(userDTO, UserEntity.class);
    }
}
