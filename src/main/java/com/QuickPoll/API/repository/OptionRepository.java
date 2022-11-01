package com.QuickPoll.API.repository;

import com.QuickPoll.API.domain.Options;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Options,Long> {
}
