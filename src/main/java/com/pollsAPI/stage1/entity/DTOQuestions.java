package com.pollsAPI.stage1.entity;

import java.util.List;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class DTOQuestions {
    

    private String question;
    private boolean mandatory;
   
    private List<DTOAnswers> answers;
}
