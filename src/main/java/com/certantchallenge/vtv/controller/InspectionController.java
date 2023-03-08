package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.InspectionDTO;
import com.certantchallenge.vtv.service.InspectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/inspections")
@RequiredArgsConstructor
public class InspectionController {
    private final InspectionService inspectionService;

    @PostMapping
    public ResponseEntity<InspectionDTO> createInspectionDTO(@Valid @RequestBody InspectionDTO inspection){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(inspectionService.createInspectionDTO(inspection));
    }
}
