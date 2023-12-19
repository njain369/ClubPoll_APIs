package com.pollsAPI.stage1.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubPollResponse {

    @Id
    private Integer id;
    
    private Integer pollId;

    private String userId;

    private Integer questionId;

    private Integer answerId;

    private String responseText;

    private Date created;

    // Constructors, getters, setters, and other methods

}
