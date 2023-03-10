package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.entity.VehicleEntity;

import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(VehicleDTO user, String id);

    VehicleDTO getVehicle(String id);

    VehicleDTO updateVehicle(VehicleDTO user, String id);

    void deleteVehicle(String id);

    List<VehicleDTO> getAllVehicles();

    VehicleEntity getVehicleById(String idVehicle);
}
