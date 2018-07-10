package com.cupcodeteam.agentclubs.service.webPrakardproperty;

import com.cupcodeteam.agentclubs.entity.TestAssetPost;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.cupcodeteam.agentclubs.controller.admin.AssetController.sleep;

@Service
public class PrakardpropertyAsset {
    private boolean result;
    WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public boolean assetPost_prakardproperty(TestAssetPost testAssetPost) {
        // ประกาศชื่อซำ้ได้
        try {
            // Login
            HtmlPage page1 = webClient.getPage("http://www.prakardproperty.com/login");
            HtmlForm form1 = page1.getFormByName("frmLoginMain");

            HtmlTextInput login_email = form1.getInputByName("login_email");
            HtmlPasswordInput login_password = form1.getInputByName("login_password");
            HtmlButton button = form1.getFirstByXPath("//button[@class='button-submit']");

            login_email.type("mm3119658@gmail.com");
            login_password.type("123456");
            button.click();

            //--------------------

            HtmlPage page2 = webClient.getPage("http://www.prakardproperty.com/properties/add");

            HtmlForm form2 = page2.getHtmlElementById("frmAddProperty");
//            System.out.println(form2);
            // set variable
            HtmlElement propertyTitle = form2.getFirstByXPath("//input[@id='propertyTitle']");
            HtmlSelect propertyType = form2.getFirstByXPath("//select[@id='propertyType']");
            HtmlSelect propertyPostType = form2.getFirstByXPath("//select[@id='propertyPostType']");

            HtmlElement propertySellPrice = form2.getFirstByXPath("//input[@id='propertySellPrice']");
            HtmlSelect propertyUnitType1 = form2.getFirstByXPath("//select[@id='propertyUnitType1']");

            HtmlElement propertyLandSizeRai = form2.getFirstByXPath("//input[@id='propertyLandSizeRai']");
            HtmlElement propertyLandSizeNgan = form2.getFirstByXPath("//input[@id='propertyLandSizeNgan']");
            HtmlElement propertyLandSizeWah = form2.getFirstByXPath("//input[@id='propertyLandSizeWah']");

            HtmlSelect province = form2.getFirstByXPath("//select[@id='province']");
            HtmlSelect district = form2.getFirstByXPath("//select[@id='district']");
            HtmlSelect subdistrict = form2.getFirstByXPath("//select[@id='subdistrict']");

            HtmlHiddenInput lat = form2.getFirstByXPath("//input[@id='lat']");
            HtmlHiddenInput lng = form2.getFirstByXPath("//input[@id='lng']");

            HtmlCheckBoxInput propertyConfirm1 = form2.getFirstByXPath("//input[@name='propertyConfirm1']");
            HtmlButton button1 = form2.getFirstByXPath("//button[@type='submit']");

            // set value
//            propertyTitle.type("ขายที่ดิน33333333333333");
//            propertyType.getOptionByText("ที่ดิน").setSelected(true);
//            propertyPostType.getOptionByText("ขาย").setSelected(true);
//
//            propertySellPrice.type("2000000");
//            propertyUnitType1.getOptionByText("บาท").setSelected(true);
//
//            propertyLandSizeRai.type("1");
//            propertyLandSizeNgan.type("1");
//            propertyLandSizeWah.type("200");
//
//            province.getOptionByText("กระบี่").setSelected(true);
//            sleep();
//            district.getOptionByText("คลองท่อม").setSelected(true);
//            sleep();
//            subdistrict.getOptionByText("คลองท่อมเหนือ").setSelected(true);
//
//            lat.setAttribute("value", "7.949085870015031");
//            lng.setAttribute("value", "99.23261916585739");

//            AssetPost assetPost1 = new AssetPost();
//            assetPost1.getAssetName();

            String title = testAssetPost.getAssetName();

            System.out.println(title);

            propertyTitle.type(title);
//System.out.println(propertyTitle);
            propertyType.getOptionByText(testAssetPost.getAssetTye()).setSelected(true);
            propertyPostType.getOptionByText(testAssetPost.getAnnouceTo()).setSelected(true);

            propertySellPrice.type("200000");
            propertyUnitType1.getOptionByText("บาท").setSelected(true);

            propertyLandSizeRai.type(testAssetPost.getRai());
            propertyLandSizeNgan.type(testAssetPost.getNgan());
            propertyLandSizeWah.type(testAssetPost.getTaranwa());

            province.getOptionByText(testAssetPost.getCangwat()).setSelected(true);
            sleep();
            district.getOptionByText(testAssetPost.getAmpor()).setSelected(true);
            sleep();
            subdistrict.getOptionByText(testAssetPost.getTambun()).setSelected(true);

            lat.setAttribute("value", testAssetPost.getmLat());
            lng.setAttribute("value", testAssetPost.getmLng());

            propertyConfirm1.setChecked(true);

            HtmlPage page3 = button1.click();
//            System.out.println(page3);

            HtmlElement div_Success = page3.getFirstByXPath("//div[@id='content']");

            if (div_Success != null) {
//                System.out.println("success");
                result = true;
                return result;
            } else {
//                System.out.println("fail");
                result = true;
                return result;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Boolean.parseBoolean(null);
    }

//    private static void sleep(){
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
