package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.InspectorDTO;
import com.certantchallenge.vtv.service.InspectorService;
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
@RequestMapping("/inspectors")
@RequiredArgsConstructor
@Api(tags = "Inspector Endpoints", value = "InspectorEndpoints")
public class InspectorController {

    private final InspectorService inspectorService;

    @PostMapping(value = "/save", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Create a inspector", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 201, message = "OK - Inspector created",
            response = InspectorDTO.class)
    public ResponseEntity<InspectorDTO> createInspector(@Valid @RequestBody InspectorDTO inspector){
        return ResponseEntity.status(HttpStatus.CREATED).body(inspectorService.createInspector(inspector));
    }
    @PutMapping(value = "/update/{id}",  produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Update a inspector", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 200, message = "OK - Inspector update",
            response = InspectorDTO.class)
    public ResponseEntity<InspectorDTO> updateInspector(@Valid @RequestBody InspectorDTO inspector, @PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(inspectorService.updateInspector(inspector, id));
    }
    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete a inspector")
    @ApiResponse(code = 204, message = "OK - Inspector deleted")
    public ResponseEntity<Void> deleteInspector(@PathVariable String id){
        inspectorService.deleteInspector(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping(value = "/get/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Get a inspector", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 200, message = "OK - get Inspector ",
            response = InspectorDTO.class)
    public ResponseEntity<InspectorDTO> getInspector(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(inspectorService.getInspector(id));
    }
    @GetMapping(produces = {"application/json"})
    @ApiOperation(value = "Get inspectors")
    @ApiResponse(code = 200, message = "OK - get Inspectors",
            response = InspectorDTO.class)
    public ResponseEntity<List<InspectorDTO>> getAllInspectors(){
        return ResponseEntity.status(HttpStatus.OK).body(inspectorService.getAllInspectors());
    }

}
