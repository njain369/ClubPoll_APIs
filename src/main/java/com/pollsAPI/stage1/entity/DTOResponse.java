package com.pollsAPI.stage1.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity; // Import JPA annotations
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOResponse {

    private Integer pollId;
    private String userId;

    private List<Question> questions;
    
    private Date created;

    // Constructors, getters, setters, and other methods
}


