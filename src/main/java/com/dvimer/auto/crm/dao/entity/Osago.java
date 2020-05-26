package com.dvimer.auto.crm.dao.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "osago"
)
public class Osago implements java.io.Serializable {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne(optional = false)
    @JoinColumn(name = "agent")
    private AgentEnity agent;
    private String kindClient;
    private String office;
    private Integer numberOffice;
    private String area;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    private String firstName;
    private String lastName;
    private String patronomic;
    private String phoneNumber;
    @OneToOne
    private InsurerEntity insurer;
    private String modelAuto;
    private String kindInsurance;
    private Integer baseRate;
    private BigDecimal price;
    private Integer sale;
    private BigDecimal priceWithSale;
    private Integer delivery;
    private BigDecimal totalAmount;
    private Integer kv;
    private BigDecimal kvAll;
    private Integer kvTotal;
    private boolean dk;
    private Integer adminSalary;
    private Integer ourSalasy;
    private Integer cashbox;
    private Integer broughtAll;
}
