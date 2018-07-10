package com.cupcodeteam.agentclubs.service.webBangkokassets;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BangkokassetsUser {
    final WebClient webClient = new WebClient(BrowserVersion.CHROME);
    public boolean registerUser(){
        try {
            HtmlPage page1 = webClient.getPage("http://www.bangkokassets.com/register.html");

//      register success but not return


            HtmlSelect Prefix= page1.getFirstByXPath("//select[@id='CphBody_DdlPrefix']");
            HtmlElement Name = page1.getFirstByXPath("//input[@id='CphBody_TxtName']");
            HtmlElement SerName = page1.getFirstByXPath("//input[@id='CphBody_TxtSurname']");
            HtmlElement Mobile = page1.getFirstByXPath("//input[@id='CphBody_TxtMobile']");
            HtmlElement Email = page1.getFirstByXPath("//input[@id='CphBody_TxtEmail']");
            HtmlElement Password = page1.getFirstByXPath("//input[@id='CphBody_TxtPassword']");
            HtmlElement RePassword = page1.getFirstByXPath("//input[@id='CphBody_TxtRePassword']");
            HtmlElement button = page1.getFirstByXPath("//input[@id='CphBody_BtnRegister']");

            Prefix.getOptionByText("นาย").setSelected(true);
            Name.type("มามะ");
            SerName.type("มามะ");
            Mobile.type("0874512356");
            Email.type("test1@hotmail.com");
            Password.type("123456");
            RePassword.type("123456");

            System.out.println(Prefix);
            System.out.println(Name);
            System.out.println(SerName);
            System.out.println(Mobile);
            System.out.println(Email);
            System.out.println(Password);
            System.out.println(RePassword);
            System.out.println(button);


            HtmlPage page2 = button.click();
            System.out.println(page2);
//            HtmlElement span_Success = page2.getFirstByXPath("//span[@id='Sfal']");
//
//            System.out.println(span_Success);
//
//            if(span_Success != null){
//                System.out.println("Success");
//            }else {
//                System.out.println("Fail");
//            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return Boolean.parseBoolean(null);
    }
}
