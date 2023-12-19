package com.pollsAPI.stage1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pollsAPI.stage1.entity.ClubPoll;
import com.pollsAPI.stage1.entity.DTO;
import com.pollsAPI.stage1.entity.DTOAnswers;
import com.pollsAPI.stage1.entity.DTOQuestions;
import com.pollsAPI.stage1.entity.DTOResponse;
import com.pollsAPI.stage1.entity.UserDTO;
import com.pollsAPI.stage1.entity.DTOTransferObjects.DTOPoll;
import com.pollsAPI.stage1.entity.DTOTransferObjects.DTOResults;
import com.pollsAPI.stage1.service.ClubPollService;

@RestController
@RequestMapping("/club/{clubId}/poll")
public class ClubPollController {

    private final ClubPollService clubPollService;

    @Autowired
    public ClubPollController(ClubPollService clubPollService) {
        this.clubPollService = clubPollService;
    }

    @PostMapping("/create")
    public ResponseEntity<ClubPoll> createPoll(
            @PathVariable Integer clubId,
            @RequestBody DTO dto
    ) {
        ClubPoll createdPoll = clubPollService.createPoll(clubId,dto);
        return ResponseEntity.ok(createdPoll);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<DTOPoll> getPolls(@PathVariable Integer pollId){
        DTOPoll dto_poll = clubPollService.getPolls(pollId);
        return ResponseEntity.ok(dto_poll);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitPoll(@PathVariable Integer clubId, @RequestBody DTOResponse dtoresponse ){
        System.out.println("Hello Flow of control is here");
        clubPollService.submitPollReponse(clubId, dtoresponse);
        return ResponseEntity.ok("cool");
       
    }

    @PostMapping("/{pollId}/results")
    public ResponseEntity<List<DTOResults>> getResults(@PathVariable Integer pollId){
        return ResponseEntity.ok(clubPollService.getResults(pollId));
    }
}
