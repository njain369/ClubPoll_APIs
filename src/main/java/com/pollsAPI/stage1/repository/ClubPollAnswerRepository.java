package com.pollsAPI.stage1.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pollsAPI.stage1.entity.ClubPollAnswer;
import java.util.List;


public interface ClubPollAnswerRepository extends JpaRepository<ClubPollAnswer, Integer> {
    // Add custom queries or methods if needed

    List<ClubPollAnswer> findByQuestionId(Integer questionId);
}

