package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.entity.OfficeEntity;
import com.dvimer.auto.crm.dao.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfficeService {

    private final OfficeRepository officeRepository;

    public List<OfficeEntity> findAll() {
        return officeRepository.findAll();
    }

    public void deleteById(UUID id) {
        officeRepository.deleteById(id);
    }

    public void save(OfficeEntity officeEntity) {
        officeEntity.setCreatedAt(LocalDateTime.now());
        officeEntity.setUpdatedAt(LocalDateTime.now());
        officeRepository.save(officeEntity);
    }

    public OfficeEntity findById(UUID id) {
        return officeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
