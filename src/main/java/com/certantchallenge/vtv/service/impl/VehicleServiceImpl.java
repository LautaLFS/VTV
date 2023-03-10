package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.VehicleEntity;
import com.certantchallenge.vtv.exception.ResourceNotFoundException;
import com.certantchallenge.vtv.mapper.InspectionMapper;
import com.certantchallenge.vtv.mapper.VehicleMapper;
import com.certantchallenge.vtv.repository.VehicleRepository;
import com.certantchallenge.vtv.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final UserServiceImpl userService;
    private final InspectionMapper inspectionMapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicle, String id) {
        var user = userService.getUserById(id);
        var vehicleEntity = vehicleMapper.toEntity(vehicle);
        vehicleEntity.setOwner(user);
        return vehicleMapper.toDto(vehicleRepository.save(vehicleEntity));
    }

    @Override
    public VehicleDTO getVehicle(String id) {
        var vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> getResourceNotFoundException(id));
        return vehicleMapper.toDto(vehicleEntity);
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicle, String id) {
        var vehicleEntity = vehicleRepository.findById(id)
              .orElseThrow(() -> getResourceNotFoundException(id));
        vehicleEntity.setBrand(vehicle.getBrand());
        vehicleEntity.setModel(vehicle.getModel());
        vehicleEntity.setDomain(vehicle.getDomain());
        var inspections = vehicle.getInspections();
        return vehicleMapper.toDto(vehicleRepository.save(vehicleEntity));
    }

    @Override
    public void deleteVehicle(String id) {
        var vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> getResourceNotFoundException(id));
        vehicleRepository.delete(vehicleEntity);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        var vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public VehicleEntity getVehicleById(String idVehicle) {
        return vehicleRepository.findById(idVehicle)
                .orElseThrow(() -> getResourceNotFoundException(idVehicle));
    }

    private ResourceNotFoundException getResourceNotFoundException(String id){
        return new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, id);
    }

}
