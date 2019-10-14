package com.dvimer.auto.crm.dao;

import com.dvimer.auto.crm.hbm2java.Agent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentsRepository extends CrudRepository<Agent, Integer> {
    List<Agent> findAll();
    List<Agent> findByName(String name);
    List<Agent> findByDeleted(boolean isDelete);
    @Modifying
    @Query("update Agent a set a.deleted = :deleted where a.id = :id")
    void updateWhereId(@Param("deleted") boolean delete, @Param("id") Integer id);

}
