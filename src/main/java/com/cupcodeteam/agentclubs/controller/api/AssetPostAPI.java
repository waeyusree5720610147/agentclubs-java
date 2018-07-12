package com.cupcodeteam.agentclubs.controller.api;

import com.cupcodeteam.agentclubs.entity.AssetPost;
import com.cupcodeteam.agentclubs.repository.AssetPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AssetPostAPI {

    @Autowired
    private AssetPostRepository assetPostRepository;

    @RequestMapping("/get_assetpost_list")
    public List<AssetPost> getAssetPostList(){
        List<AssetPost> assetPosts  = this.assetPostRepository.findAll();

        return  assetPosts;
    }

    @RequestMapping("/get_assetpost_by_id/{id}")
    public AssetPost getAssetPostById(@PathVariable int id){
        AssetPost assetPost = this.assetPostRepository.findOneById(id);

        return assetPost;
    }
}
