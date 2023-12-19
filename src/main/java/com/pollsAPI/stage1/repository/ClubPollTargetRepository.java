package com.pollsAPI.stage1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pollsAPI.stage1.entity.ClubPollTarget;

public interface ClubPollTargetRepository extends JpaRepository<ClubPollTarget, Integer> {
    // Add custom queries or methods if needed
}
