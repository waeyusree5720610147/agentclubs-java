package com.cupcodeteam.agentclubs.controller.admin;

import com.cupcodeteam.agentclubs.entity.TestAssetPost;
import com.cupcodeteam.agentclubs.repository.TestAssetPostRepository;
import com.cupcodeteam.agentclubs.service.webDdTeedin.DdteedinAsset;
import com.cupcodeteam.agentclubs.service.webPrakardproperty.PrakardpropertyAsset;
import com.cupcodeteam.agentclubs.service.webTeedin108.Teedin108Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/asset")
public class AssetController {
    @Autowired
    DdteedinAsset ddteedinAsset;
    @Autowired
    Teedin108Asset teedin108Asset;
    @Autowired
    PrakardpropertyAsset prakardpropertyAsset;

    //---------
    @Autowired
    TestAssetPostRepository testAssetPostRepository;

    //---------
    private boolean result_Ddteedin_AP;
    private boolean result_Teedin108_AP;
    private boolean result_prakardproperty_AP;


    @RequestMapping(value = "/assetpost" ,method = RequestMethod.POST)
//    @RequestMapping("/assetpost")
    public @ResponseBody void postAsset(
            TestAssetPost testAssetPost
    ){

//        assetPostRepository.save(assetPost);
//        result_Ddteedin_AP = this.ddteedinAsset.assetPost_ddteedin(testAssetPost);
//        result_Teedin108_AP = this.teedin108Asset.assetPost_teedin108(testAssetPost);
        result_prakardproperty_AP = this.prakardpropertyAsset.assetPost_prakardproperty(testAssetPost);

        System.out.println("Ddteedin = " + result_Ddteedin_AP);
        System.out.println("Teedin108 = " + result_Teedin108_AP);
        System.out.println("Prakardproperty = " + result_prakardproperty_AP);
    }



    //---Sleep download data---
    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
