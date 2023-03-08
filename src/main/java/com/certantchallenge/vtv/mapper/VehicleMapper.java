package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.VehicleEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VehicleMapper extends ModelMapper {
    TypeMap<VehicleEntity, VehicleDTO> mapper = createTypeMap(VehicleEntity.class, VehicleDTO.class)
            .addMappings(mapping -> mapping.map( src -> src.getOwner().getName(),VehicleDTO::setOwner));
    public VehicleDTO toDto(VehicleEntity vehicleEntity){
        return map(vehicleEntity, VehicleDTO.class);
    }
    public VehicleEntity toEntity(VehicleDTO vehicleEntity){return map(vehicleEntity, VehicleEntity.class);
    }
}
