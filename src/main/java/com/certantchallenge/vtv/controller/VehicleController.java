package com.certantchallenge.vtv.controller;


import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
@Api(tags = "Vehicle Endpoints", value = "VehicleEndpoints")
public class VehicleController {

    private final VehicleService vehicleService;
    @PostMapping(value = "/register/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Save a vehicle", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 201, message = "OK - Vehicle was successfully registered",
            response = VehicleDTO.class)
    public ResponseEntity<VehicleDTO> createVehicle(@Valid @RequestBody VehicleDTO vehicle,
                                                 @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.saveVehicle(vehicle, id));
    }
    @GetMapping(value = "/{id}", produces = {"application/json"})
    @ApiOperation(value = "Get a vehicle", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - Vehicle was successfully generated",
            response = VehicleDTO.class)
    public ResponseEntity<VehicleDTO> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(id));
    }

    @GetMapping(produces = {"application/json"})
    @ApiOperation(value = "Get vehicles", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - Vehicles was successfully generated",
            response = VehicleDTO.class)
    public ResponseEntity<List<VehicleDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }

    @PutMapping(value = "/update/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Update a vehicle", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 202, message = "OK - Vehicle was updated successfully",
            response = VehicleDTO.class)
    public ResponseEntity<VehicleDTO> updateVehicle(@Valid @PathVariable String id, @RequestBody VehicleDTO vehicle){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(vehicleService.updateVehicle(vehicle, id));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete a vehicle")
    @ApiResponse(code = 204, message = "OK - Vehicle was deleted")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable String id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
