package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class VehicleDTO {
    @Id
    @JsonIgnore
    private String id;

    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private String domain;
    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private String model;
    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private String brand;
    private String owner;
}
