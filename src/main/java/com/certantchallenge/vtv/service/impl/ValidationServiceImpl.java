package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.ClientResponse;
import com.certantchallenge.vtv.dto.InspectionRequest;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.entity.VehicleEntity;
import com.certantchallenge.vtv.mapper.*;
import com.certantchallenge.vtv.service.InspectionService;
import com.certantchallenge.vtv.service.UserService;
import com.certantchallenge.vtv.service.ValidationService;
import com.certantchallenge.vtv.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final ValidationMapper validationMapper;
    private final VehicleService vehicleService;
    private final InspectionService inspectionService;
    private final VehicleMapper vehicleMapper;
    private final InspectionMapper inspectionMapper;

    @Override
    public ClientResponse getClientInfo(String idClient) {
        var client = userMapper.toEntity(userService.getUser(idClient));
        var vehicles = client.getVehicles();
        List<InspectionEntity> inspections = new ArrayList<>();
        for (VehicleEntity vehicle : vehicles ){
            inspections.addAll(vehicle.getInspections());
        }
        return validationMapper.toClientResponse(client);
    }


    public InspectionResponse setInspection(String idVehicle, String idInspection, InspectionRequest inspectionRequest) {
        var vehicle = vehicleService.getVehicleById(idVehicle);
        var inspection = inspectionService.findInspection(idInspection);
        inspection.setObservation(inspectionRequest.getObservation().equals(true));
        inspection.setMeasurement(inspectionRequest.getMeasurement().equals(true));
        vehicle.getInspections().add(inspection);
        vehicleService.updateVehicle(vehicleMapper.toDto(vehicle), idVehicle);
        inspectionService.updateInspectionDTO(inspectionMapper.toDto(inspection),
                idInspection, idVehicle, inspection.getInspector().getId());
        return validationMapper.toSetInspectionResponse(inspection);
    }

    @Override
    public InspectionResponse check(String idInspection) {
        var inspection = inspectionService.findInspection(idInspection);
        if (Boolean.TRUE.equals(inspection.getMeasurement()) && Boolean.TRUE.equals(inspection.getObservation())) {
            inspection.setState(AppConstants.APPROVED);
        } else if (Boolean.FALSE.equals(inspection.getMeasurement()) && Boolean.FALSE.equals(inspection.getObservation())) {
            inspection.setState(AppConstants.REJECTED);
        }else{
            inspection.setState(AppConstants.CONDITIONAL);
        }
        inspectionService.updateInspectionDTO(inspectionMapper.toDto(inspection),
                idInspection, null, null);
        return validationMapper.toSetInspectionResponse(inspection);
    }
}
