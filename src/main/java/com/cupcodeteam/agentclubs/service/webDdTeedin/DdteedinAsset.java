package com.cupcodeteam.agentclubs.service.webDdTeedin;

import com.cupcodeteam.agentclubs.entity.TestAssetPost;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.cupcodeteam.agentclubs.controller.AssetController.sleep;

@Service
public class DdteedinAsset {
//    @Autowired
//    DdteedinUser ddteedinUser;

    WebClient webClient = new WebClient(BrowserVersion.CHROME);
    public Boolean assetPost_ddteedin(TestAssetPost testAssetPost){
        try {
//--------LogIn----------
//            ddteedinUser.loginUser();
            final HtmlPage page1 = webClient.getPage("https://www.ddteedin.com/login");
            final HtmlForm form = page1.getHtmlElementById("pn_login");
//            System.out.println(form);
            final HtmlSubmitInput button1 = form.getInputByName("login");
            final HtmlTextInput user1 = form.getInputByName("log_u");
            user1.type("Test@hotmail.com");
            final HtmlPasswordInput pass = form.getInputByName("log_p");
            pass.type("123456");
            button1.click();
//------------------------
//upper part
            final HtmlPage page2 = webClient.getPage("https://www.ddteedin.com/post-land-for-sale");
            System.out.println(page2);

            final HtmlForm form2 = page2.getFormByName("form1");

            final HtmlTextInput name = form2.getInputByName("name");
            final List<HtmlRadioButtonInput> radio1_list =form2.getRadioButtonsByName("forid");
            final HtmlSelect select = form2.getSelectByName("typeid");
//                final List<HtmlRadioButtonInput> radio2_list =form2.getRadioButtonsByName("isnew");
//----------------------------
//Map_Location
            final HtmlTextInput street = form2.getInputByName("street");
            final HtmlTextInput soi    = form2.getInputByName("soi");
            final HtmlSelect province  = form2.getSelectByName("province");
            final HtmlSelect amphur    = form2.getSelectByName("amphur");
            final HtmlSelect tumbon    = form2.getSelectByName("tumbon");
//-----------------------------
//special character
            final List<HtmlInput> checkboc_list= form2.getInputsByName("opts[]");
//-----------------------------
//detail querySelector
            final HtmlTextArea detail = form2.getTextAreaByName("detail");
//-----------------------------
//image
            final HtmlFileInput files = form2.getInputByName("files");
//            System.out.println("file = " + files);
//----------------------------
//submit
            final HtmlSubmitInput button2 = form2.getInputByName("btn_submit");

//                     ----------SetValue---------

            name.type("ขายที่ดินสวยงาม3333333333");
            for (HtmlRadioButtonInput radioButton1 : radio1_list) {
                if (radioButton1.getValueAttribute().equalsIgnoreCase("1")) {
                    radioButton1.setChecked(true);
//                    System.out.println("SSS_RadioButton1");
                }
            }
            select.getOptionByValue("3").setSelected(true);
//            for (HtmlRadioButtonInput radioButton2 : radio2_list) {
//                if (radioButton2.getValueAttribute().equalsIgnoreCase("1")) {
//                    radioButton2.setChecked(true);
////                    System.out.println("SSS_RadioButton2");
//                }
//            }

//            System.out.println("111"+form2);
//            System.out.println("111"+name);
//            System.out.println("111"+radio1_list);
//            System.out.println("111"+select);
//            System.out.println("111"+radio2_list);
//----------------------------
//Map_Location
            street.type("คลองเทียน");
            soi.type("โชคบุญมี");
            province.getOptionByText("เพชรบุรี").setSelected(true);
            amphur.getOptionByText("ชะอำ").setSelected(true);
            tumbon.getOptionByText("ชะอำ").setSelected(true);

//            System.out.println("222"+street);
//            System.out.println("222"+soi);
//            System.out.println("222"+province);
//            System.out.println("222"+amphur);
//            System.out.println("222"+tumbon);
//-----------------------------
//special character
            for (HtmlInput a : checkboc_list) {
                if(a.getValueAttribute().equals("1")){
                    a.setChecked(true);
                }
            }
//            System.out.println("333"+checkboc_list);

//-----------------------------
//detail
            detail.type("พื้นที่กว้างและส่วยงาม");
//            System.out.println("444"+detail);
//-----------------------------
//image
//                files.setValueAttribute("C:\\Users\\YusReE_MS\\Desktop\\1.png");
//                files.setContentType("multipart/form-data");
//----------------------------
//submit
            sleep();
            HtmlPage page3 = button2.click();

            HtmlElement div_success = page3.getFirstByXPath("//div[@id='postinfo']");

            if(div_success != null){
//                System.out.println("success");
                return true;
            }else {
//                System.out.println("fail");
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    return false;
    }

}

