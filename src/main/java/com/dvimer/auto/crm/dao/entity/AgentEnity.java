package com.dvimer.auto.crm.dao.entity;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "agent")
@SQLDelete(sql = "UPDATE agent SET status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 'DELETED'")
public class AgentEnity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String status;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;
}
