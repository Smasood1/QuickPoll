package com.QuickPoll.API.controllers;

import com.QuickPoll.API.domain.Vote;
import com.QuickPoll.API.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class VoteController {

@Autowired
    private VoteRepository voteRepository;

@Autowired
    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }


    @RequestMapping(value="/polls/{pollId}/votes", method= RequestMethod.POST)
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote){

        vote = voteRepository.save(vote);

        //set headers for newly created resource

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);

    }

    @RequestMapping(value="/polls/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(){
        return voteRepository.findAll();
    }

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Optional<Vote> getAllVote(@PathVariable Long pollId) {
        return voteRepository.findById(pollId);
    }

}
