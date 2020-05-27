package com.dvimer.auto.crm.service;

import com.dvimer.auto.crm.dao.entity.AgentEnity;
import com.dvimer.auto.crm.dao.repository.AgentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgentService {

    private final AgentsRepository agentsRepository;

    public List<AgentEnity> findAll() {
        return agentsRepository.findAll(new Sort(Sort.Direction.ASC,"name"));
    }

    public AgentEnity findById(int id) {
        return agentsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void save(AgentEnity agentEnity) {
        agentEnity.setStatus("ACTIVE");
        agentsRepository.save(agentEnity);
    }

    public void deleteById(int id) {
        agentsRepository.deleteById(id);
    }
}
