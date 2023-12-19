package com.pollsAPI.stage1.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicInteger;
import com.pollsAPI.stage1.entity.*;
import com.pollsAPI.stage1.entity.DTOTransferObjects.DTOPoll;
import com.pollsAPI.stage1.entity.DTOTransferObjects.DTOResults;
import com.pollsAPI.stage1.repository.*;


@Service
public class ClubPollService {

    private final ClubPollRepository clubPollRepository;
    private final ClubPollTargetRepository clubPollTargetRepository;
    private final ClubPollQuestionRepository clubPollQuestionRepository;
    private final ClubPollAnswerRepository clubPollAnswerRepository;
    private final ClubPollResponseRepository clubPollResponseRepository;

    @Autowired
    public ClubPollService(
            ClubPollRepository clubPollRepository,
            ClubPollTargetRepository clubPollTargetRepository,
            ClubPollQuestionRepository clubPollQuestionRepository,
            ClubPollAnswerRepository clubPollAnswerRepository,
            ClubPollResponseRepository clubPollResponseRepository
    ) {
        this.clubPollRepository = clubPollRepository;
        this.clubPollTargetRepository = clubPollTargetRepository;
        this.clubPollQuestionRepository = clubPollQuestionRepository;
        this.clubPollAnswerRepository = clubPollAnswerRepository;
        this.clubPollResponseRepository = clubPollResponseRepository;
    }

    
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static int generateUniqueId() {
        return counter.getAndIncrement();
    }

    public ClubPoll createPoll(Integer clubId, DTO dto) {
        // Set clubId for the poll
       //Adding data to relations table.
        List<DTOQuestions> dtoq = dto.getQuestions();
        int pollId = generateUniqueId();
        Date currentDate = new Date(System.currentTimeMillis());
        ClubPoll cp = new ClubPoll();
        cp.setId(pollId);
        cp.setClubId(clubId+"");
        cp.setTitle(dto.getTitle());
        cp.setDescription(dto.getDescription());
        cp.setStartDate(dto.getStartDate());
        cp.setStartTime(dto.getStartTime());
        cp.setEndDate(dto.getEndDate());
        cp.setEndTime(dto.getEndTime());
        cp.setActive(dto.isActive());
        cp.setCanDismiss(dto.isCanDismiss());
        cp.setCreated(currentDate);
        cp.setCreatedBy(dto.getCreatedBy());
        cp.setType(dto.getType());

        clubPollRepository.save(cp);
        
        ClubPollTarget cpt = new ClubPollTarget();
        System.out.print("ID of poll is "+cp.getId());
        cpt.setClubPollId(cp.getId()+"");
        cpt.setCreated(currentDate);
        cpt.setId(generateUniqueId());
        cpt.setTargets("ALL");
        cpt.setUpdated(currentDate);

        clubPollTargetRepository.save(cpt);

        List<DTOQuestions> list_of_questions = dto.getQuestions();
        for(DTOQuestions question: list_of_questions){
             ClubPollQuestion cpq = new ClubPollQuestion();
             int questionId = generateUniqueId();
             cpq.setCreated(currentDate);
             cpq.setCreatedBy(dto.getCreatedBy());
             cpq.setId(questionId);
             cpq.setQuestion(question.getQuestion());
           
             List<DTOAnswers> answers = question.getAnswers();
             for(DTOAnswers ans : answers){
                ClubPollAnswer cpa = new ClubPollAnswer();
                cpa.setAnswer(ans.getAnswer());
                cpa.setCreated(currentDate);
                cpa.setCreatedBy(dto.getCreatedBy());
                cpa.setId(generateUniqueId());
                cpa.setQuestionId(questionId);
                cpa.setMandatory(ans.isMandatory());
                clubPollAnswerRepository.save(cpa);
             }
             System.out.println("Storing poll id in each question "+pollId);
             cpq.setPollId(cp.getId());

             clubPollQuestionRepository.save(cpq);
             
        }

        return cp;


    }
    
    public void submitPollReponse(Integer clubId, DTOResponse dtor){
        
        List<Question> questions = dtor.getQuestions();
        
        for(Question q : questions){
            List<Answer> answers = q.getAnswers();
           for(Answer ans: answers){
        ClubPollResponse cpr =new ClubPollResponse();
        cpr.setId(generateUniqueId());
        
            cpr.setPollId(dtor.getPollId());
            cpr.setUserId(dtor.getUserId());
            cpr.setQuestionId(q.getQuestionId());
            if(ans.getAnswerId()==null){
               cpr.setResponseText(q.getResponseText());
               cpr.setAnswerId(null);
            }else{ 
            cpr.setAnswerId(ans.getAnswerId());
            cpr.setResponseText(null);
            }
            cpr.setCreated(dtor.getCreated());
         
           clubPollResponseRepository.save(cpr);   
        } 
        }
        
        
           
    }
    public DTOPoll getPolls(Integer pollId){

        DTOPoll dto_for_transfer = new DTOPoll();
        ClubPollQuestion dto_questions = new ClubPollQuestion();
        ClubPollAnswer dto_answers = new ClubPollAnswer();

        Optional<ClubPoll> optional = clubPollRepository.findById(pollId);
        ClubPoll poll = optional.get();
        dto_for_transfer.setActive(poll.isActive());
        dto_for_transfer.setCanDismiss(poll.isCanDismiss());
        dto_for_transfer.setCreatedBy(poll.getCreatedBy());
        dto_for_transfer.setDescription(poll.getDescription());
        dto_for_transfer.setEndDate(poll.getEndDate());
        dto_for_transfer.setEndTime(poll.getEndTime());
        dto_for_transfer.setStartDate(poll.getStartDate());
        dto_for_transfer.setStartTime(poll.getStartTime());
        dto_for_transfer.setId(pollId);
        dto_for_transfer.setTitle(poll.getTitle());
        dto_for_transfer.setType(poll.getType());
        

        List<ClubPollQuestion> optional_ques= clubPollQuestionRepository.findByPollId(pollId);
        dto_for_transfer.setQuestions(optional_ques);
        List<List<ClubPollAnswer>> answers = new ArrayList<List<ClubPollAnswer>>();
        for(ClubPollQuestion ques: optional_ques){
            int questionId = ques.getId();
            List<ClubPollAnswer> optional_answer = clubPollAnswerRepository.findByQuestionId(questionId);
            answers.add(optional_answer); 
        }
        dto_for_transfer.setQuestions(optional_ques);
        dto_for_transfer.setAnswers(answers);
        return dto_for_transfer;
    }

    public List<DTOResults> getResults(Integer pollId){

        List<ClubPollResponse> answerLists = clubPollResponseRepository.findByPollId(pollId);
        Map<Integer, Integer> answerCountMap = new HashMap<>(); // Map to store answerId and its count

        // Count occurrences of each unique answer
       for (ClubPollResponse cpr : answerLists) {
        Integer answerId = cpr.getAnswerId();
        answerCountMap.put(answerId, answerCountMap.getOrDefault(answerId, 0) + 1);
       }

       // Create DTOResults instances based on the counts
       List<DTOResults> listFormatResults = new ArrayList<>();
       for (Map.Entry<Integer, Integer> entry : answerCountMap.entrySet()) {
        Integer answerId = entry.getKey();
        Integer count = entry.getValue();

        Optional<ClubPollAnswer> optionalCpa = clubPollAnswerRepository.findById(answerId);

        if (optionalCpa.isPresent()) {
            ClubPollAnswer cpa = optionalCpa.get();

            // Assuming DTOResults has appropriate constructor or setter methods
            DTOResults resultsFormat = new DTOResults();
            resultsFormat.setAnswer_in_word(cpa.getAnswer()); // Assuming there's a method to get answer text
            resultsFormat.setCount(count);

            listFormatResults.add(resultsFormat);
        }
    }

    return listFormatResults;

    }    

}
