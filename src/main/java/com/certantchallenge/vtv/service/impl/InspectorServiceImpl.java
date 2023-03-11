package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.InspectorDTO;
import com.certantchallenge.vtv.entity.InspectorEntity;
import com.certantchallenge.vtv.exception.ResourceNotFoundException;
import com.certantchallenge.vtv.mapper.InspectorMapper;
import com.certantchallenge.vtv.repository.InspectorRepository;
import com.certantchallenge.vtv.service.InspectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InspectorServiceImpl implements InspectorService {

    private final InspectorMapper inspectorMapper;
    private final InspectorRepository inspectorRepository;

    @Override
    public InspectorEntity getInspectorById(String idInspector) {
        return inspectorRepository.findById(idInspector).orElseThrow(
                ()-> getResourceNotFoundException(idInspector));
    }

    @Override
    public InspectorDTO getInspector(String idInspector) {
        return inspectorMapper.toDto(inspectorRepository.findById(idInspector).orElseThrow(
                ()-> getResourceNotFoundException(idInspector)
        ));
    }

    @Override
    public InspectorDTO createInspector(InspectorDTO inspector) {
        return inspectorMapper.toDto(inspectorRepository.save(inspectorMapper.toEntity(inspector)));
    }

    @Override
    public InspectorDTO updateInspector(InspectorDTO inspector, String id) {
        return null;
    }

    @Override
    public List<InspectorDTO> getAllInspectors() {
        return null;
    }

    @Override
    public Void deleteInspector(String id) {
        var inspector = findInspector(id);
        inspectorRepository.delete(inspector);
        return null;
    }
    public InspectorEntity findInspector(String id){
        return inspectorRepository.findById(id).orElseThrow(
                () -> getResourceNotFoundException(id));
    }

    private ResourceNotFoundException getResourceNotFoundException(String id){
        return new ResourceNotFoundException(AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, id);
    }
}
