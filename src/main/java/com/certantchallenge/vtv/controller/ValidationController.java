package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.ClientResponse;
import com.certantchallenge.vtv.dto.InspectionRequest;
import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.service.ValidationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checks")
@RequiredArgsConstructor
@Api(tags = "Validation Endpoints", value = "ValidationEndpoints")
public class ValidationController {
    private final ValidationService validationService;

    @GetMapping(value = "/getClient/{idClient}", produces = {"application/json"})
    @ApiOperation(value = "get client info", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - get client information",
            response = ClientResponse.class)
    public ResponseEntity<ClientResponse> getClientInfo(@PathVariable String idClient) {
       return ResponseEntity.ok(validationService.getClientInfo(idClient));
    }


    @PatchMapping(value = "/setInspection/{idVehicle}/inspection/{idInspection}", produces = {"application/json"})
    @ApiOperation(value = "set inspection", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - Set inspection",
            response = InspectionResponse.class)
    public ResponseEntity<?> setInspection(@RequestBody InspectionRequest inspectionRequest, @PathVariable String idVehicle, @PathVariable String idInspection) {
        return ResponseEntity.ok(validationService.setInspection(idVehicle, idInspection, inspectionRequest));
    }
    @PatchMapping(value = "/check/{idInspection}", produces = {"application/json"})
    @ApiOperation(value = "Check status of the inspection", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - Vehicle status checked",
            response = InspectionResponse.class)
    public ResponseEntity<?> check(@PathVariable String idInspection) {
        return ResponseEntity.ok(validationService.check(idInspection));
    }

}
