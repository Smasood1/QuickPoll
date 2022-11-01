package com.QuickPoll.API.controllers;

import com.QuickPoll.API.domain.Poll;
import com.QuickPoll.API.exception.ResourceNotFoundException;
import com.QuickPoll.API.repository.PollRepository;
import com.QuickPoll.API.service.PollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


    @RestController
    public class PollController {

        @Autowired
        private PollService pollService;

        @GetMapping("/polls")
        public ResponseEntity<Iterable<Poll>> getAllPolls() {
            return pollService.getAllPolls();
        }

        @PostMapping("/polls")
        public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll) {
            return pollService.createPoll(poll);
        }


        @GetMapping("/polls/{pollId}")
        public ResponseEntity<?> getPoll(@PathVariable Long pollId) {
            return pollService.getPoll(pollId);
        }

        @PutMapping("/polls/{pollId}")
        public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollID) {

            return pollService.updatePoll(poll, pollID);
        }

        @DeleteMapping("/polls/{pollID}")
        public ResponseEntity<?> deletePoll(@PathVariable Long pollId) {

            return pollService.deletePoll(pollId);
        }
    }




