package com.cupcodeteam.agentclubs.controller;

import com.cupcodeteam.agentclubs.entity.User;
import com.cupcodeteam.agentclubs.repository.UserRepository;
import com.cupcodeteam.agentclubs.service.webDdTeedin.DdteedinUser;
import com.cupcodeteam.agentclubs.service.webPrakardproperty.PrakardpropertyUser;
import com.cupcodeteam.agentclubs.service.webTeedin108.Teedin108User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DdteedinUser ddteedinUser;
    @Autowired
    private Teedin108User teedin108User;
//    @Autowired
//    private DdproportyUser ddproportyUser; ---Security---
    @Autowired
    private PrakardpropertyUser prakardpropertyUser;

    private boolean result_Ddteedin;
    private boolean result_Teedin108;
    private boolean result_prakardproperty;

    @RequestMapping("/register")
//    public @ResponseBody List<User> member(Model model){
//    public RegisterUserResponse register(User user, Model model){
    public void register(User user, Model model){
        result_Ddteedin = this.ddteedinUser.registerUser(user);
        result_Teedin108 = this.teedin108User.registerUser(user);
        result_prakardproperty = this.prakardpropertyUser.registerUser(user);
//        ddproportyUser.addUser(user);  ---Security---



//        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
//        RegisterUserResult registerUserResult = new RegisterUserResult();
//        registerUserResult.setAssetName("ddproperty");
//        registerUserResult.setResult("true");
//        registerUserResponse.addResult(registerUserResult);
//         registerUserResult = new RegisterUserResult();
//        registerUserResult.setAssetName("web2");
//        registerUserResult.setResult("false");
//        registerUserResponse.addResult(registerUserResult);
//        return  registerUserResponse;
    }

    @RequestMapping("/login")
    public void loginUser(){

        result_Ddteedin = this.ddteedinUser.loginUser();
        result_prakardproperty = this.prakardpropertyUser.loginUser();
        result_Teedin108 = this.teedin108User.loginUser();

        System.out.println("Ddteedin : "+result_Ddteedin);
        System.out.println("prakardproperty : "+result_prakardproperty);
        System.out.println("Teedin108 : "+result_Teedin108);
    }

    @RequestMapping("/loguot")
    public void loguotUser(){
        ddteedinUser.loguotUser();
    }

}
