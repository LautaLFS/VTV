package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.StickerDTO;
import com.certantchallenge.vtv.service.StickerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stickers")
@RequiredArgsConstructor
@Api(tags = "Sticker Endpoints", value = "StickerEndpoints")
public class StickerController {

    private final StickerService stickerService;

    @PostMapping(value = "/save/{vehicleId}", produces = {"application/json"})
    @ApiOperation(value = "Save a sticker", produces = "application/json")
    @ApiResponse(code = 202, message = "OK - Sticker created",
            response = StickerDTO.class)
    public ResponseEntity<StickerDTO> saveSticker(@PathVariable String vehicleId) throws Exception {
        var sticker = new StickerDTO();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(stickerService.saveSticker(sticker, vehicleId));
    }

}
