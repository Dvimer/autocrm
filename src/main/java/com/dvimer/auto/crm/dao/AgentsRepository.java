package com.dvimer.auto.crm.dao;

import com.dvimer.auto.crm.hbm2java.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentsRepository extends JpaRepository<Agent, Integer> {
}
