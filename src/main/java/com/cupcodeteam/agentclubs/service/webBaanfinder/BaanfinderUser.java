package com.cupcodeteam.agentclubs.service.webBaanfinder;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BaanfinderUser {
    final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public boolean loginUser(){
        try {
            HtmlPage page1 = webClient.getPage("https://www.baanfinder.com/login");

            HtmlForm form1 = page1.getHtmlElementById("loginForm");
            System.out.println(form1);

            HtmlEmailInput email = form1.getInputByName("username");
            HtmlPasswordInput password = form1.getInputByName("password");
            HtmlSubmitInput submit = form1.getFirstByXPath("//input[@id='signin']");

            email.type("test@hotmail.com");
            password.type("12345");

            HtmlPage page2 = submit.click();
            System.out.println(page2);
            HtmlElement img_Success = page2.getFirstByXPath("//img[@class='photo  img-responsive']");

            if (img_Success != null) {
                return true;
            } else {
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
