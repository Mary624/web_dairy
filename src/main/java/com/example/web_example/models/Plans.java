package com.example.web_example.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="plans")
public class Plans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="text_plan")
    private String textPlan;

    @Column(name="date_plan")
    private Date datePlan;

    private boolean important;
}
