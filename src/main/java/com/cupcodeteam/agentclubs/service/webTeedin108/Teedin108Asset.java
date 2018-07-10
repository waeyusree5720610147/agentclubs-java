package com.cupcodeteam.agentclubs.service.webTeedin108;


import com.cupcodeteam.agentclubs.entity.AssetPost;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Teedin108Asset {
    WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public boolean assetPost_teedin108(AssetPost assetPost) {
        try {
            //-----Login
            HtmlPage page1 = webClient.getPage("https://www.teedin108.com/member/login/");

            HtmlElement txtEmail = page1.getFirstByXPath("//input[@id='txtEmail']");
            HtmlElement txtPassword = page1.getFirstByXPath("//input[@id='txtPassword']");
            HtmlElement btnLogin = page1.getFirstByXPath("//input[@id='btnLogin']");

            txtEmail.type("mm3119658@gmail.com");
            txtPassword.type("123456");
            btnLogin.click();

            //--------------------

            HtmlPage page2 = webClient.getPage("https://www.teedin108.com/post/");

            HtmlForm form2 = page2.getHtmlElementById("form");
//            System.out.println(form2);

            List<HtmlRadioButtonInput> list_post = form2.getRadioButtonsByName("data[post_type_code]");
            List<HtmlRadioButtonInput> list_property = form2.getRadioButtonsByName("data[property_type_code]");
            HtmlSelect geo_id = form2.getSelectByName("data[geo_id]");
            HtmlSelect province_id = form2.getSelectByName("data[province_id]");
            HtmlSelect amphur_id = form2.getSelectByName("data[amphur_id]");
            HtmlSelect district_id = form2.getSelectByName("data[district_id]");
            HtmlTextInput subject = form2.getInputByName("data[subject]");
            HtmlTextInput price = form2.getInputByName("data[price]");
            HtmlTextArea description = form2.getTextAreaByName("data[description]");
            HtmlTextInput password = form2.getInputByName("data[password]");
            HtmlButton submit = form2.getFirstByXPath("//button[@id='btnSubmit']");



            for (HtmlRadioButtonInput post : list_post){
                if (post.getValueAttribute().equalsIgnoreCase("S")) {
                    post.setChecked(true);
                    System.out.println("SSS_RadioButton1");
                }
            }
            for (HtmlRadioButtonInput property : list_property){
                if (property.getValueAttribute().equalsIgnoreCase("L")) {
                    property.setChecked(true);
                    System.out.println("SSS_RadioButton1");
                }
            }
            geo_id.getOptionByText("ภาคกลาง").setSelected(true);
            province_id.getOptionByText("กรุงเทพมหานคร").setSelected(true);
            amphur_id.getOptionByText("เขตคลองเตย").setSelected(true);
            district_id.getOptionByText("คลองตัน").setSelected(true);

            subject.type("ขายที่ดินงาม333333333");
            price.type("20000");
            description.type("ที่ดินสวย");

            password.type("123456");

            submit.click();
            HtmlButton button1 = page2.getFirstByXPath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-focus']");

            HtmlPage page3 = button1.click();
//            System.out.println(page3);
            HtmlElement h1_Success = page3.getFirstByXPath("//h1[@class='keyword padding-top-10 padding-bottom-10']");

//            System.out.println(h1_Success);

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
