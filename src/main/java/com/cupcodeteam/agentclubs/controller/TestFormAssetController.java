package com.cupcodeteam.agentclubs.controller;

import com.cupcodeteam.agentclubs.entity.AssetPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestFormAssetController {
    @RequestMapping("/formAsset")
    public String testFormAsset(Model model){
        model.addAttribute("assetPost", new AssetPost());

        return "assetForm";
    }
}
