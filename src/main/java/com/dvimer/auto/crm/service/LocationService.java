package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.entity.LocationEntity;
import com.dvimer.auto.crm.dao.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;

    public List<LocationEntity> findAll() {
        return locationRepository.findAll();
    }

    public void deleteById(UUID id) {
        locationRepository.deleteById(id);
    }

    public void save(LocationEntity locationEntity) {
        locationEntity.setCreatedAt(LocalDateTime.now());
        locationEntity.setUpdatedAt(LocalDateTime.now());
        locationRepository.save(locationEntity);
    }

    public LocationEntity findById(UUID id) {
        return locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
