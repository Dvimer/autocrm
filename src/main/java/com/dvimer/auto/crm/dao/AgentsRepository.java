package com.dvimer.auto.crm.dao;

import com.dvimer.auto.crm.entity.AgentEnity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentsRepository extends JpaRepository<AgentEnity, Integer> {
    List<AgentEnity> findByName(String name);

    List<AgentEnity> findByDeleted(boolean isDelete);

    @Modifying
    @Query("update AgentEnity a set a.deleted = :deleted where a.id = :id")
    void updateWhereId(@Param("deleted") boolean delete, @Param("id") Integer id);

}
