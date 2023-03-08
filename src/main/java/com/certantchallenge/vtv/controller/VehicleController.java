package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.VehicleDTO;
import com.certantchallenge.vtv.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    @PostMapping("/register/{id}")
    public ResponseEntity<VehicleDTO> createUser(@Valid @RequestBody VehicleDTO vehicle,
                                                 @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.saveVehicle(vehicle, id));
    }
    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(id));
    }

    @GetMapping()
    public ResponseEntity<List<VehicleDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<VehicleDTO> updateUser(@Valid @PathVariable String id, @RequestBody VehicleDTO vehicle){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(vehicleService.updateVehicle(vehicle, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VehicleDTO> deleteUser(@PathVariable String id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
