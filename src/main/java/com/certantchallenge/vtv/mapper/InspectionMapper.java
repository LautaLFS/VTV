package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class InspectionMapper extends ModelMapper {

    public InspectionResponse toResponse(InspectionEntity inspection){
        return map(inspection, InspectionResponse.class);
    }
    public InspectionDTO toDto(InspectionEntity inspection){
        return map(inspection, InspectionDTO.class);
    }
    public InspectionEntity toEntity(InspectionDTO inspectionDTO){
        return map(inspectionDTO, InspectionEntity.class);
    }
    public InspectionEntity toEntity(InspectionResponse response){
        return map(response, InspectionEntity.class);
    }
}
