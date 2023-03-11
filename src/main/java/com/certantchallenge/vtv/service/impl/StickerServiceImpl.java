package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.StickerDTO;
import com.certantchallenge.vtv.entity.InspectionEntity;
import com.certantchallenge.vtv.mapper.StickerMapper;
import com.certantchallenge.vtv.repository.StickerRepository;
import com.certantchallenge.vtv.service.InspectionService;
import com.certantchallenge.vtv.service.StickerService;
import com.certantchallenge.vtv.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class StickerServiceImpl implements StickerService {

    private final VehicleService vehicleService;
    private final StickerMapper stickerMapper;
    private final StickerRepository stickerRepository;
    private Random random = new Random();
    private final InspectionService inspectionService;

    @Override
    public StickerDTO saveSticker(StickerDTO sticker, String vehicleId) throws Exception {
        InspectionEntity inspection = inspectionService.findInspectionByVehicleId(vehicleId);
        if (!inspection.getState().equals(AppConstants.APPROVED)) {
            throw new Exception("Inspectio n state must be APPROVED");
        }
        sticker.setRegistrationNumber(random.nextInt(50001));
        sticker.setExpiration(calculateExpDate());
        var vehicle = vehicleService.getVehicleById(vehicleId);
        sticker.setDomainVehicle(vehicle.getDomain());
        sticker.setIsApproved(true);
        stickerRepository.save(stickerMapper.toEntity(sticker));
        return sticker;
    }
    private Timestamp calculateExpDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(System.currentTimeMillis()));
        calendar.add(Calendar.YEAR, 1);
        return new Timestamp(calendar.getTimeInMillis());
    }
}
