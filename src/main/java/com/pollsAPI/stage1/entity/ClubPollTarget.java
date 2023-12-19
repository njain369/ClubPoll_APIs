package com.pollsAPI.stage1.entity;

import java.sql.Date;
import java.time.LocalDateTime;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubPollTarget {
    @Id
    private Integer Id;
    private String clubPollId;
    private Date created;
    private Date updated;
    private String targets;
}
