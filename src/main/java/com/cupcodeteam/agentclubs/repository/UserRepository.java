package com.cupcodeteam.agentclubs.repository;

import com.cupcodeteam.agentclubs.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>{

    @RestResource
    List<User> findAll();
}
