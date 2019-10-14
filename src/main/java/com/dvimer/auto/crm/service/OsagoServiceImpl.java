package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.OsagoRepository;
import com.dvimer.auto.crm.hbm2java.Osago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsagoServiceImpl implements OsagoService {

    private OsagoRepository osagoRepository;

    @Autowired
    public OsagoServiceImpl(OsagoRepository osagoRepository) {
        this.osagoRepository = osagoRepository;
    }

    @Override
    public List<Osago> findAll() {
        return osagoRepository.findAll();
    }

    @Override
    public Osago findById(int id) {

        Optional<Osago> result = osagoRepository.findById(id);

        Osago osago;

        if (result.isPresent()) osago = result.orElseGet(Osago::new);
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return osago;
    }

    @Override
    public void save(Osago osago) {
        osagoRepository.save(osago);
    }

    @Override
    public void deleteById(int id) {
        osagoRepository.deleteById(id);
    }
}
