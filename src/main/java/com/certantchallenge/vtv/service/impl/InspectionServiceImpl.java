package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.exception.ResourceNotFoundException;
import com.certantchallenge.vtv.mapper.InspectionMapper;
import com.certantchallenge.vtv.repository.InspectionRepository;
import com.certantchallenge.vtv.service.InspectionService;
import com.certantchallenge.vtv.service.InspectorService;
import com.certantchallenge.vtv.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {

    private final InspectionRepository inspectionRepository;
    private final InspectionMapper inspectionMapper;
    private final InspectorService inspectorService ;
    private final VehicleService vehicleService;

    @Override
    public InspectionResponse createInspection(InspectionDTO inspection, String idInspector, String idVehicle) {
        var vehicle = vehicleService.getVehicle(idVehicle);
        var inspector = inspectorService.getInspector(idInspector);
        inspection.setVehicle(vehicle);
        inspection.setInspector(inspector);
        inspection.setMeasurement(Boolean.FALSE);
        inspection.setObservation(Boolean.FALSE);
        inspection.setState(AppConstants.DEFAULT_STATE);
        return inspectionMapper.toResponse(inspectionRepository.save(inspectionMapper.toEntity(inspection)));
    }

    @Override
    public InspectionResponse updateInspectionDTO(InspectionDTO inspection, String id, String idVehicle, String idInspector) {
        var inspectionEntity = findInspection(id);
        inspectionEntity.setNroInspection(inspection.getNroInspection());
        inspectionEntity.setObservation(inspection.getObservation());
        inspectionEntity.setMeasurement(inspection.getMeasurement());
        if(inspection.getState() != null){
            inspectionEntity.setState(inspection.getState());
        }
        if (inspection.getIsExempt() != null) {
            inspectionEntity.setIsExempt(inspection.getIsExempt());
        }
        if (idInspector != null){
            var inspector = inspectorService.getInspectorById(idInspector);
            inspectionEntity.setInspector(inspector);
        }if (idVehicle != null){
            var vehicle = vehicleService.getVehicleById(idVehicle);
            inspectionEntity.setVehicle(vehicle);
        }
        return inspectionMapper.toResponse(inspectionRepository.save(inspectionEntity));
    }

    @Override
    public void deleteInspectionDTO(String id) {
        var inspectionEntity = findInspection(id);
        inspectionRepository.delete(inspectionEntity);
    }

    @Override
    public InspectionResponse getInspectionDTO(String id) {
        return inspectionMapper.toResponse(inspectionRepository.findById(id).orElseThrow(
                ()-> getResourceNotFoundException(id)
        ));
    }

    @Override
    public List<InspectionResponse> getAllInspections() {
        var inspections = inspectionRepository.findAll();
        return inspections.stream().map(inspectionMapper::toResponse)
                .collect(Collectors.toList());
    }
    private ResourceNotFoundException getResourceNotFoundException(String id){
        return new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, id);
    }

    @Override
    public InspectionEntity findInspection(String id){
        return inspectionRepository.findById(id).orElseThrow(
                () -> getResourceNotFoundException(id));
    }

    @Override
    public List<InspectionResponse> findVehiclesByState(String state) {
        var inspections = inspectionRepository.findByState(state);
        return inspections.stream().map(inspectionMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public InspectionEntity findInspectionByVehicleId(String id) {
        return inspectionRepository.findByVehicleId(id).orElseThrow(
                () -> getResourceNotFoundException(id));
    }

}
