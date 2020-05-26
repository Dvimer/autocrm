package com.dvimer.auto.crm.dao.repository;

import com.dvimer.auto.crm.dao.entity.InsurerEntity;
import com.dvimer.auto.crm.dao.entity.OfficeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<OfficeEntity, UUID> {
}
