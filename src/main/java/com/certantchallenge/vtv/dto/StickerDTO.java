package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StickerDTO {
    private Integer registrationNumber;
    @ApiModelProperty(dataType = "Date", example = "2022/09/20")
    private Timestamp expiration;
    @JsonIgnore
    private VehicleDTO vehicle;
    private String domainVehicle;
    private Boolean isApproved;
}
