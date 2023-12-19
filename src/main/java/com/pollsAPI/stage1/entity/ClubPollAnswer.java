package com.pollsAPI.stage1.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ClubPollAnswer {
   
    @Id
    private Integer Id;

    private Integer questionId;
    private String answer;
    private boolean mandatory;
    private Date created;
    private String createdBy;
    
}
