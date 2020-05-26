package com.dvimer.auto.crm.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
@SQLDelete(sql = "UPDATE location SET status = 'DELETED' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "status <> 'DELETED'")
public class LocationEntity {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
