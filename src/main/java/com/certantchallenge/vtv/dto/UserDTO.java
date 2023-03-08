package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDTO {

    @Id
    @JsonIgnore
    private String id;
    @NotEmpty(message = "must not be empty")
    @Size(min = 4, message = "Must have 4 characters")
    private String name;
    private Boolean isExempt;
    List<VehicleDTO> vehicles = new ArrayList<>();

}
