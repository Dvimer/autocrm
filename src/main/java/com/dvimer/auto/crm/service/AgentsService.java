package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.hbm2java.Agent;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AgentsService {

    List<Agent> findAll();

    List<Agent> findByName(String name);

    Agent findById(int id);

    void save(Agent osago);

    @Transactional()
    void deleteById(int id);

    @Transactional
    List<Agent> findAllNotDelete();
}
