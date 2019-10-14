package com.dvimer.auto.crm.hbm2java;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agent")
public class Agent implements java.io.Serializable {
    private Integer id;
    private String name;
    private boolean deleted;

    public Agent() {
    }

    public Agent(Integer id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public Agent(Integer id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "deleted")
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id) &&
                Objects.equals(name, agent.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
