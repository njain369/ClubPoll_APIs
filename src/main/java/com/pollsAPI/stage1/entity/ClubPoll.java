package com.pollsAPI.stage1.entity;



import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubPoll{

   
    @Id
    private Integer id;

    private String clubId;
    private String title;
    private String description;

    private Date startDate;
    private Time startTime;
    private Date endDate;
    private Time endTime;
    private boolean active;
    private boolean canDismiss;
    private String type;

    private Date created;
    private String createdBy;

    

}