package com.pollsAPI.stage1.entity;

import java.sql.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;



@Data
public class DTOAnswers {
 


    private String answer;
    private boolean mandatory;
}
