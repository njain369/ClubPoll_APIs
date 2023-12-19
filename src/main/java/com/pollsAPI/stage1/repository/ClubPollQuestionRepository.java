package com.pollsAPI.stage1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pollsAPI.stage1.entity.ClubPollQuestion;
import java.util.List;


public interface ClubPollQuestionRepository extends JpaRepository<ClubPollQuestion, Integer> {
    // Add custom queries or methods if needed

       List<ClubPollQuestion> findByPollId(Integer pollId);
       
}
