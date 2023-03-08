package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.InspectionDTO;

import java.util.List;

public interface InspectionService {

    InspectionDTO createInspectionDTO(InspectionDTO inspection);

    InspectionDTO updateInspectionDTO(InspectionDTO inspection);

    void deleteInspectionDTO(InspectionDTO inspection);

    InspectionDTO getInspectionDTO(String id);

    List<InspectionDTO> getAllInspections();
}
