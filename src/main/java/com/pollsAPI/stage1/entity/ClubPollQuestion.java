package com.pollsAPI.stage1.entity;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClubPollQuestion {
    
    @Id
    private Integer Id;
    private Integer pollId;
    private String question;
    private boolean mandatory;
    private Date created;
    private String createdBy;
    



}
