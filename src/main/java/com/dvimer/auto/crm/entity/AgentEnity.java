package com.dvimer.auto.crm.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "agent")
public class AgentEnity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private boolean deleted;
}
