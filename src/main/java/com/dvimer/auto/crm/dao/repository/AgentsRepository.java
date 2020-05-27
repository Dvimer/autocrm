package com.dvimer.auto.crm.dao.repository;

import com.dvimer.auto.crm.dao.entity.AgentEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentsRepository extends JpaRepository<AgentEnity, Integer> {
    List<AgentEnity> findByName(String name);
}
