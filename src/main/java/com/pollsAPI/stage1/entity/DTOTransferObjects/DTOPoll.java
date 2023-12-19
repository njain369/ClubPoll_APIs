package com.pollsAPI.stage1.entity.DTOTransferObjects;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.pollsAPI.stage1.entity.ClubPollAnswer;
import com.pollsAPI.stage1.entity.ClubPollQuestion;
import com.pollsAPI.stage1.entity.DTOQuestions;

import lombok.Data;

@Data
public class DTOPoll {
 
      
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
    private List<ClubPollQuestion> questions;
    private List<List<ClubPollAnswer>> answers;
    
}
