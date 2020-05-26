package com.dvimer.auto.crm.dao.repository;

import com.dvimer.auto.crm.dao.entity.Osago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OsagoRepository extends JpaRepository<Osago, UUID> {
}
