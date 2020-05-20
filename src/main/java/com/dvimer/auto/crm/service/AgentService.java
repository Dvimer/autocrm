package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.AgentsRepository;
import com.dvimer.auto.crm.entity.AgentEnity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentsRepository agentsRepository;

    public List<AgentEnity> findAll() {
        return agentsRepository.findAll();
    }

    public List<AgentEnity> findByName(String name) {
        return agentsRepository.findByName(name);
    }

    public AgentEnity findById(int id) {
        return agentsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(AgentEnity agentEnity) {
        agentsRepository.save(agentEnity);
    }

    public void deleteById(int id) {
        agentsRepository.updateWhereId(true, id);
    }

    public List<AgentEnity> findAllNotDelete() {
        return agentsRepository.findByDeleted(false);
    }
}
