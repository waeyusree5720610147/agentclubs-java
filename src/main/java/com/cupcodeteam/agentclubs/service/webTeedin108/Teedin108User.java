package com.cupcodeteam.agentclubs.service.webTeedin108;

import com.cupcodeteam.agentclubs.entity.User;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;

import java.io.IOException;

//import org.openqa.selenium.firefox.FirefoxDriver;

@Service
public class Teedin108User {

    final WebClient webClient = new WebClient(BrowserVersion.CHROME);
    private boolean result;

    public boolean loginUser(){
        try {
            HtmlPage page1 = webClient.getPage("https://www.teedin108.com/member/login/");
//            System.out.println(page1);

            HtmlElement txtEmail = page1.getFirstByXPath("//input[@id='txtEmail']");
            HtmlElement txtPassword = page1.getFirstByXPath("//input[@id='txtPassword']");
            HtmlElement btnLogin = page1.getFirstByXPath("//input[@id='btnLogin']");

//            System.out.println(txtEmail);
//            System.out.println(txtPassword);
//            System.out.println(btnLogin);

            txtEmail.type("mm3119658@gmail.com");
            txtPassword.type("123456");

            HtmlPage page2 = btnLogin.click();
            HtmlElement h1_Success = page2.getFirstByXPath("//h1[@class='keyword padding-bottom-20']");

            if(h1_Success != null){
                result = true;
                return result;
            }else {
                result = false;
                return result;
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

        return Boolean.parseBoolean(null);
    }

    public boolean registerUser(User user) {
        try {
            HtmlPage page1 = webClient.getPage("https://www.teedin108.com/member/register/");
//            System.out.println(page1);
            //---Set Variable
            HtmlElement txtEmail = page1.getFirstByXPath("//input[@id='txtEmail']");
            HtmlElement txtName = page1.getFirstByXPath("//input[@id='txtName']");
            HtmlElement txtTelephone = page1.getFirstByXPath("//input[@id='txtTelephone']");
            HtmlElement txtPassword = page1.getFirstByXPath("//input[@id='txtPassword']");
            HtmlElement chkAcceptPolicy = page1.getFirstByXPath("//input[@id='chkAcceptPolicy']");
            HtmlElement btnSubmit = page1.getFirstByXPath("//input[@id='btnSubmit']");

//            System.out.println(txtEmail);
//            System.out.println(txtName);
//            System.out.println(txtTelephone);
//            System.out.println(txtPassword);
//            System.out.println(chkAcceptPolicy);
//            System.out.println(btnSubmit);

            //---Set Value
            txtEmail.type("mm3119658@gmail.com");
            txtName.type("Mama Mama");
            txtTelephone.type("0875946589");
            txtPassword.type("123456");
            chkAcceptPolicy.click();

            HtmlPage page2 = btnSubmit.click();
            HtmlElement div_Success = page2.getFirstByXPath("//div[@class='alert alert-success']");

            if(div_Success != null){
//                System.out.println("Success");
                result = true;
                return result;
            }else{
//                System.out.println("Fail");
                result = false;
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Boolean.parseBoolean(null);
    }
}
