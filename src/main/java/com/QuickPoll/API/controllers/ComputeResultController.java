package com.QuickPoll.API.controllers;


import com.QuickPoll.API.domain.Vote;
import com.QuickPoll.API.dtos.VoteResult;
import com.QuickPoll.API.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
    public class ComputeResultController {

        @Autowired
        private VoteRepository voteRepository;

        @Autowired
        public ComputeResultController(VoteRepository voteRepository) {
            this.voteRepository = voteRepository;
        }

        @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
        public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
            VoteResult voteResult = new VoteResult();
            Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);
            return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
        }
    }
