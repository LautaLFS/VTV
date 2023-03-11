package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.InspectorDTO;
import com.certantchallenge.vtv.entity.InspectorEntity;

import java.util.List;

public interface InspectorService {
    InspectorEntity getInspectorById(String idInspector);

    InspectorDTO getInspector(String idInspector);

    InspectorDTO createInspector(InspectorDTO inspector);

    InspectorDTO updateInspector(InspectorDTO inspector, String id);

    List<InspectorDTO> getAllInspectors();

    Void deleteInspector(String id);
}
