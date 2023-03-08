package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class InspectionDTO {
    @Id
    @JsonIgnore
    private String id;

    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private Integer nroInspection;
    private Timestamp timestamps;
    private VehicleDTO vehicleDTO;
    private InspectorDTO inspectorDTO;
    
}
