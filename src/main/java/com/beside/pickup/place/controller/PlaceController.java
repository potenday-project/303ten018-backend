package com.beside.pickup.place.controller;

import com.beside.pickup.place.domain.Place;
import com.beside.pickup.place.domain.dto.PlaceDto;
import com.beside.pickup.place.service.PlaceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/place")
public class PlaceController {

    private final PlaceService placeService;

    @Operation(summary = "장소 전체 조회", description = "장소 전체 조회", tags = { "장소" })
    @GetMapping("")
    public ResponseEntity<List<Place>> addUser() {
        List<PlaceDto> placeDtoList =
                placeService.findAllPlace()
                .stream()
                .map(PlaceDto::toPlaceDto)
                .collect(Collectors.toList());

        return new ResponseEntity(placeDtoList, HttpStatus.OK);
    }

}
