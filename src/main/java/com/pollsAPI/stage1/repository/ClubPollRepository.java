package com.pollsAPI.stage1.repository;

import com.pollsAPI.stage1.entity.ClubPoll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubPollRepository extends JpaRepository<ClubPoll, Integer> {
    // You can add custom queries or methods if needed
}
