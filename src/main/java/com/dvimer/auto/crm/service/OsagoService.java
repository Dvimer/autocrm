package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.repository.OsagoRepository;
import com.dvimer.auto.crm.dao.entity.Osago;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OsagoService {

    private final OsagoRepository osagoRepository;

    public List<Osago> findAll() {
        return osagoRepository.findAll();
    }

    public Osago findById(UUID id) {
        return osagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(Osago osago) {
        osago.setStatus("ACTIVE");
        osagoRepository.save(osago);
    }

    public void deleteById(UUID id) {
        osagoRepository.deleteById(id);
    }
}
