package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.hbm2java.Agent;

import java.util.List;

public interface AgentsService {

    List<Agent> findAll();

    Agent findById(int id);

    void save(Agent osago);

    void deleteById(int id);
}
