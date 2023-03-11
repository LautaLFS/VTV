package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.entity.InspectionEntity;

import java.util.List;

public interface InspectionService {

    InspectionResponse createInspection(InspectionDTO inspection, String idInspector, String idVehicle);

    InspectionResponse updateInspectionDTO(InspectionDTO inspection, String id, String idVehicle, String idInspector);

    void deleteInspectionDTO(String id);

    InspectionResponse getInspectionDTO(String id);

    List<InspectionResponse> getAllInspections();

    InspectionEntity findInspection(String id);

    List<InspectionResponse> findVehiclesByState(String state);

    InspectionEntity findInspectionByVehicleId(String id);
}
