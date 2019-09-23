package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.hbm2java.Osago;

import java.util.List;

public interface OsagoService {
    List<Osago> findAll();

    Osago findById(int id);

    void save(Osago osago);

    void deleteById(int id);
}
