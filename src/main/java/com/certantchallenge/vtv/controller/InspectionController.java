package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.service.InspectionService;
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
@RequestMapping("/inspections")
@RequiredArgsConstructor
@Api(tags = "Inspection Endpoints", value = "InspectionEndpoints")
public class InspectionController {
    private final InspectionService inspectionService;

    @PostMapping(value = "save/{idInspector}/{idVehicle}",
            produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Create a inspection", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 201, message = "OK - Inspection created",
            response = InspectionResponse.class)
    public ResponseEntity<InspectionResponse> createInspection(@Valid @RequestBody InspectionDTO inspection,
                                                                  @PathVariable String idInspector,
                                                                  @PathVariable String idVehicle){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inspectionService.createInspection(inspection, idInspector, idVehicle));
    }
    @PutMapping(value = "/update/{idInspection}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Update a inspection", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 200, message = "OK - Inspection updated successfully",
            response = InspectionResponse.class)
    public ResponseEntity<InspectionResponse> updateInspectionDTO(
            @RequestParam(required = false) String idInspector,
            @RequestParam(required = false) String idVehicle,
            @Valid @RequestBody InspectionDTO inspection,
            @PathVariable String idInspection){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
              .body(inspectionService.updateInspectionDTO(inspection, idInspection, idVehicle, idInspector));
    }
    @DeleteMapping(value = "/delete/{idInspection}")
    @ApiOperation(value = "Delete a inspection")
    @ApiResponse(code = 204, message = "OK - Inspection deleted")
    public ResponseEntity<InspectionResponse> deleteInspectionDTO(@PathVariable String idInspection){
        inspectionService.deleteInspectionDTO(idInspection);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping(value = "/{idInspection}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Get a inspection", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 200, message = "OK - get Inspection",
            response = InspectionResponse.class)
    public ResponseEntity<InspectionResponse> getInspectionDTO(@PathVariable String idInspection){
        return ResponseEntity.status(HttpStatus.OK)
             .body(inspectionService.getInspectionDTO(idInspection));
    }
    @GetMapping(produces = {"application/json"})
    @ApiOperation(value = "Get inspections")
    @ApiResponse(code = 200, message = "OK - get Inspections",
            response = InspectionResponse.class)
    public ResponseEntity<List<InspectionResponse>> getAllInspectionDTO(){
        return ResponseEntity.status(HttpStatus.OK)
            .body(inspectionService.getAllInspections());
    }

    @GetMapping(value = "/orderBy", produces = {"application/json"})
    @ApiOperation(value = "Order inspections by state", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - get Inspections by state",
            response = InspectionResponse.class)
    public ResponseEntity<List<InspectionResponse>> orderByState(@RequestParam(defaultValue = AppConstants.DEFAULT_STATE) String state){
        return ResponseEntity.status(HttpStatus.OK).body(inspectionService.findVehiclesByState(state));
    }
}
