package com.beside.pickup.place.domain.dto;

import com.beside.pickup.place.domain.Place;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDto {
    private Long id;
    private String shortAddress;
    private String detailAddress;

    public static PlaceDto toPlaceDto(Place place) {
        return PlaceDto.builder()
                .id(place.getId())
                .shortAddress(place.getShortAddress())
                .detailAddress(place.getDetailAddress())
                .build();
    }
}
