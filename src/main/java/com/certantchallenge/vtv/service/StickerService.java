package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.StickerDTO;

public interface StickerService {
    StickerDTO saveSticker(StickerDTO sticker, String vehicleId) throws Exception;
}
