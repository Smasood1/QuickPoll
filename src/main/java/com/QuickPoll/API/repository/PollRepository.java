package com.QuickPoll.API.repository;

import com.QuickPoll.API.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll,Long> {
}
