package com.cupcodeteam.agentclubs.service.webPrakardproperty;

import com.cupcodeteam.agentclubs.entity.User;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PrakardpropertyUser {

    WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public boolean loginUser(){
        try {
            HtmlPage page1 = webClient.getPage("http://www.prakardproperty.com/login");
            HtmlForm form1 = page1.getFormByName("frmLoginMain");

            HtmlTextInput login_email = form1.getInputByName("login_email");
            HtmlPasswordInput login_password = form1.getInputByName("login_password");
            HtmlButton button = form1.getFirstByXPath("//button[@class='button-submit']");

            login_email.type("mm3119658@gmail.com");
            login_password.type("123456");
            HtmlPage page2 = button.click();

            HtmlForm form_success = page2.getFirstByXPath("//form[@name='frmMemberAccount']");
//            String Url_Success = page2.getUrl().toString();
            if(form_success != null){
//                System.out.println("Success_Prakardproperty");
                return true;
            }else {
//                System.out.println("Fail_Prakardproperty");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }

    public boolean registerUser(User user) {
        try {
            HtmlPage page1 = webClient.getPage("http://www.prakardproperty.com/register");
            HtmlForm form1 = page1.getFormByName("frmRegister");
//            System.out.println(form1);

            //---Set Variable
            HtmlTextInput memberEmail = form1.getFirstByXPath("//input[@id='memberEmail']");
            HtmlPasswordInput memberPassword = form1.getFirstByXPath("//input[@id='memberPassword']");
            HtmlPasswordInput memberRePassword = form1.getFirstByXPath("//input[@id='memberRePassword']");
            HtmlTextInput memberDisplayName = form1.getFirstByXPath("//input[@id='memberDisplayName']");
            HtmlTextInput memberMobile = form1.getFirstByXPath("//input[@id='memberMobile']");
            HtmlCheckBoxInput memberAgent = form1.getFirstByXPath("//input[@id='memberAgent']");
            HtmlButton button = form1.getFirstByXPath("//button[@class='button-submit']");

            //---Set Value
            memberEmail.type("mm658@gmail.com");
            memberPassword.type("123456");
            memberRePassword.type("123456");
            memberDisplayName.type("ha");
            memberMobile.type("087564897");
            memberAgent.setChecked(true);

            HtmlPage page2 = button.click();
            HtmlElement h1_Success = page2.getFirstByXPath("//h1[@class='headline']");

            if(h1_Success != null){
//                System.out.println("Success");
                return true;
            }else {
//                System.out.println("Fail");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return false;
    }
}
