package com.certantchallenge.vtv.mapper;

import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.dto.StickerDTO;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.entity.StickerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Component;

@Component
public class StickerMapper extends ModelMapper {
    /*TypeMap<InspectionResponse, InspectionEntity> typeMap = createTypeMap(InspectionResponse.class, InspectionEntity.class)
            .addMapping(InspectionResponse::getVehicle, InspectionEntity::setVehicle);*/
    public StickerDTO toDto(StickerEntity sticker){
        return map(sticker, StickerDTO.class);
    }
    public StickerEntity toEntity(StickerDTO sticker){
        return map(sticker, StickerEntity.class);
    }
}
