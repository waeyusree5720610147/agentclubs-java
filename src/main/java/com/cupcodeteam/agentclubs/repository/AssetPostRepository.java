package com.cupcodeteam.agentclubs.repository;

import com.cupcodeteam.agentclubs.entity.AssetPost;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface AssetPostRepository extends PagingAndSortingRepository<AssetPost, Integer> {

    @RestResource
    List<AssetPost> findAll();

    @RestResource
    AssetPost findOneById(@Param("id") Integer id);
}
