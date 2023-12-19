package com.pollsAPI.stage1.repository;

import com.pollsAPI.stage1.entity.ClubPoll;
import com.pollsAPI.stage1.entity.ClubPollResponse;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ClubPollResponseRepository extends JpaRepository<ClubPollResponse, Integer > {
    // You can add custom queries or methods if neede

    List<ClubPollResponse> findByPollId(Integer pollId);
}
