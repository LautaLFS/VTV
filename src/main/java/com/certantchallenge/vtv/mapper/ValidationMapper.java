package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.ClientResponse;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.entity.UserEntity;
import com.certantchallenge.vtv.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ValidationMapper extends ModelMapper {

    TypeMap<UserEntity, ClientResponse> mapper = createTypeMap(UserEntity.class, ClientResponse.class);
    TypeMap<InspectionEntity, ClientResponse> mapperInspection = createTypeMap(InspectionEntity.class, ClientResponse.class);
    public ClientResponse toClientResponse(UserEntity client) {
        return map(client, ClientResponse.class);
    }


    public InspectionResponse toSetInspectionResponse(InspectionEntity inspection) {
        return map(inspection, InspectionResponse.class);
    }
}
