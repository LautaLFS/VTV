package com.certantchallenge.vtv.service;


import com.certantchallenge.vtv.dto.ClientResponse;
import com.certantchallenge.vtv.dto.InspectionRequest;

public interface ValidationService {

    ClientResponse getClientInfo(String idClient);

    Object setInspection(String idVehicle, String idInspection, InspectionRequest inspectionRequest);

    Object check(String idInspection);
}
