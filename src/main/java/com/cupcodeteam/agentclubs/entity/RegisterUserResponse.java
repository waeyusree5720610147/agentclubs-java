package com.cupcodeteam.agentclubs.entity;

import java.util.ArrayList;
import java.util.List;

public class RegisterUserResponse {
    private List<RegisterUserResult> registerUserResultList;

    public void addResult(RegisterUserResult registerUserResult){
        if(registerUserResultList!=null){
            registerUserResultList = new ArrayList<>();
        }
        registerUserResultList.add(registerUserResult);
    }
    public List<RegisterUserResult> getRegisterUserResultList() {
        return registerUserResultList;
    }

    public void setRegisterUserResultList(List<RegisterUserResult> registerUserResultList) {
        this.registerUserResultList = registerUserResultList;
    }
}
