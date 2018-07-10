package com.cupcodeteam.agentclubs.repository;

import com.cupcodeteam.agentclubs.entity.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Integer> {

    @RestResource
    List<Contact> findAll();

}
