package com.pollsAPI.stage1.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question{

    private Integer questionId;
    private List<Answer> answers;
    private String type;
    private String responseText;

}