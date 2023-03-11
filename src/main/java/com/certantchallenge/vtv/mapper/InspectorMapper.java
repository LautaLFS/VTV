package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.InspectorDTO;
import com.certantchallenge.vtv.entity.InspectorEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class InspectorMapper extends ModelMapper {
    public InspectorDTO toDto(InspectorEntity inspector){
        return map(inspector, InspectorDTO.class);
    }
    public InspectorEntity toEntity(InspectorDTO inspectorDTO){
        return map(inspectorDTO, InspectorEntity.class);
    }
}
