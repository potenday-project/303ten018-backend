package com.beside.pickup.place.service;

import com.beside.pickup.place.domain.Place;
import com.beside.pickup.place.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> findAllPlace() {
        return placeRepository.findAll();
    }
}
