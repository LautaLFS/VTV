package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
public class InspectionResponse {
    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private Integer nroInspection;
    @ApiModelProperty(dataType = "Date", example = "2022/09/20")
    private Timestamp timestamps;
    @JsonBackReference
    @Lazy
    private VehicleDTO vehicle;
    private InspectorDTO inspector;
    private String state;
    private Boolean observation;
    private Boolean measurement;
    @JsonIgnore
    private Boolean isExempt;
}
