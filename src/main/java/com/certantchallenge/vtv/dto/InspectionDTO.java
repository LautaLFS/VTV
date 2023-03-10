package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InspectionDTO {
    @Id
    @JsonIgnore
    private String id;
    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private Integer nroInspection;
    @ApiModelProperty(dataType = "Date", example = "2022/09/20")
    private Timestamp timestamps;
    @JsonBackReference
    @Lazy
    private VehicleDTO vehicle;
    private InspectorDTO inspector;
    private Boolean measurement;
    private Boolean observation;
    private Boolean isExempt;
    private String state;
}
