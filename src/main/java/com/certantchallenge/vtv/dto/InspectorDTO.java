package com.certantchallenge.vtv.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class InspectorDTO {
    @Id
    @JsonIgnore
    private String id;
    private String name;
}
