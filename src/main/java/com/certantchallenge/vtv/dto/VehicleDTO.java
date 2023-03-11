package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String owner;
    @JsonManagedReference
    @JsonIgnore
    private Set<InspectionResponse> inspections = new HashSet<>();
}
