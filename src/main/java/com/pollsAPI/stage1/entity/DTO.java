package com.pollsAPI.stage1.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
public class DTO {
    
    private Integer id;

    private String title;
    private String description;
    
    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Time endTime;
    private boolean active;
    private boolean canDismiss;
    private String type;
    //private Date created;
    private String createdBy;
    private List<DTOQuestions> questions;
}
