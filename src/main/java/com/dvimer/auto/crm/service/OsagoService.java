package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.OsagoRepository;
import com.dvimer.auto.crm.entity.Osago;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OsagoService {

    private final OsagoRepository osagoRepository;

    public List<Osago> findAll() {
        return osagoRepository.findAll();
    }

    public Osago findById(int id) {
        return osagoRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(Osago osago) {
        osagoRepository.save(osago);
    }

    public void deleteById(int id) {
        osagoRepository.deleteById(id);
    }
}
