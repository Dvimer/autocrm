package com.dvimer.auto.crm.dao.repository;

import com.dvimer.auto.crm.dao.entity.InsurerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InsurerRepository extends JpaRepository<InsurerEntity, UUID> {
}
