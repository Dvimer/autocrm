package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.entity.InsurerEntity;
import com.dvimer.auto.crm.dao.repository.InsurerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InsurerService {

    private final InsurerRepository insurerRepository;

    public List<InsurerEntity> findAll() {
        return insurerRepository.findAll();
    }

    public void deleteById(UUID id) {
        insurerRepository.deleteById(id);
    }

    public void save(InsurerEntity insurerEntity) {
        insurerEntity.setCreatedAt(LocalDateTime.now());
        insurerEntity.setUpdatedAt(LocalDateTime.now());
        insurerRepository.save(insurerEntity);
    }

    public InsurerEntity findById(UUID id) {
        return insurerRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }
}
