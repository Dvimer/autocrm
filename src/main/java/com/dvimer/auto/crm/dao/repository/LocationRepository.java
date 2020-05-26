package com.dvimer.auto.crm.dao.repository;

import com.dvimer.auto.crm.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LocationRepository extends JpaRepository<LocationEntity, UUID> {
}
