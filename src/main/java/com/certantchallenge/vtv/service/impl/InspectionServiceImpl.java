package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {


    @Override
    public InspectionDTO createInspectionDTO(InspectionDTO inspection) {
        return null;
    }

    @Override
    public InspectionDTO updateInspectionDTO(InspectionDTO inspection) {
        return null;
    }

    @Override
    public void deleteInspectionDTO(InspectionDTO inspection) {

    }

    @Override
    public InspectionDTO getInspectionDTO(String id) {
        return null;
    }

    @Override
    public List<InspectionDTO> getAllInspections() {
        return null;
    }
}
