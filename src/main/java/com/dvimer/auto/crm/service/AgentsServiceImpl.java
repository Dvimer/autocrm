package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.AgentsRepository;
import com.dvimer.auto.crm.dao.EmployeeRepository;
import com.dvimer.auto.crm.entity.Employee;
import com.dvimer.auto.crm.hbm2java.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentsServiceImpl implements AgentsService {

    private AgentsRepository agentsRepository;

    @Autowired
    public AgentsServiceImpl(AgentsRepository agentsRepository) {
        this.agentsRepository = agentsRepository;
    }

    @Override
    public List<Agent> findAll() {

        return agentsRepository.findAll();
    }

    @Override
    public List<Agent> findByName(String name) {
        return agentsRepository.findByName(name);
    }

    @Override
    public Agent findById(int id) {
        Optional<Agent> result = agentsRepository.findById(id);
        Agent agent;
        if (result.isPresent()) {
            agent = result.orElseGet(Agent::new);
        } else {
            throw new RuntimeException("Did not find agent id - " + id);
        }
        return agent;
    }

    @Override
    public void save(Agent Agent) {
        agentsRepository.save(Agent);
    }

    @Override
    public void deleteById(int id) {

        agentsRepository.updateWhereId(true, id);
//        Optional<Agent> byId = agentsRepository.findById(id);
//        //todo проверить перед удалением
//        if (byId.isPresent()) {
//            Agent agent = byId.get();
//            agent.setDeleted(true);
//            agentsRepository.save(agent);
//        }
    }

    @Override
    public List<Agent> findAllNotDelete() {
        return agentsRepository.findByDeleted(false);
    }
}
