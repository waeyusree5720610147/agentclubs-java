package com.cupcodeteam.agentclubs.service.webDdTeedin;

import com.cupcodeteam.agentclubs.entity.Register;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//import org.openqa.selenium.firefox.FirefoxDriver;

@Service
public class DdteedinUser {
    final WebClient webClient = new WebClient(BrowserVersion.CHROME);

    public boolean loginUser(){
//---------------------
        try {
            final HtmlPage page1 = webClient.getPage("https://www.ddteedin.com/login");
            final HtmlForm form = page1.getHtmlElementById("pn_login");
//            System.out.println(form);
            final HtmlSubmitInput button = form.getInputByName("login");
            final HtmlTextInput user1 = form.getInputByName("log_u");
            user1.type("Test@hotmail.com");

            final HtmlPasswordInput pass = form.getInputByName("log_p");
            pass.type("123456");
            final HtmlPage page2 = button.click();
//            System.out.println(" dddd " + page2.getUrl().toString());
//            String urlPage1 = page2.getUrl().toString(); // chang Url is String
//            String urlpage2 = "https://www.ddteedin.com/profile?rf=check";
            HtmlForm form_Success = page2.getFirstByXPath("//form[@class='searchbox clear']");
//            System.out.println(urlPage1);
            boolean result;
            if (form_Success != null ){
                result = true;
//                System.out.println("Success_Ddteedin");
                return result;
            }else {
//                System.out.println("Fail_Ddteedin");
                result = false;
                return result;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        HtmlUnitDriver driver = new HtmlUnitDriver();
//        driver.get("https://www.ddteedin.com/login");
//        System.out.println("Title of the page is = " + driver.getTitle());
//
//        driver.findElement(By.name("log_u")).sendKeys("Test@hotmail.com");
//        driver.findElement(By.name("log_p")).sendKeys("123456");
//        driver.findElement(By.name("login")).click();
        return Boolean.parseBoolean(null);
    }

    public boolean registerUser(Register register){
//        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
//        final HtmlPage page;
        try {
            final HtmlPage page1 = webClient.getPage("https://www.ddteedin.com/register/");

            // Get the form that we are dealing with and within that form,
            // find the submit button and the field that we want to change.
            final HtmlForm form = page1.getFormByName("formReg");

            final HtmlSubmitInput button = form.getInputByName("btSubmit");
            final HtmlTextInput email = form.getInputByName("email");
            final HtmlPasswordInput password = form.getInputByName("password");
            final HtmlPasswordInput password2 = form.getInputByName("password2");
            final HtmlTextInput firstname = form.getInputByName("firstname");
            final HtmlTextInput lastname = form.getInputByName("lastname");
            final HtmlTextInput mobile = form.getInputByName("mobile");
            final HtmlCheckBoxInput accept_term = form.getInputByValue("1");
            email.type("kanyarat6@cupcodeteam.com");
            password.type("nutoar03");
            password2.type("nutoar03");
            firstname.type("nutoar03");
            lastname.type("nutoar03");
            mobile.type("0839162226");
            accept_term.setChecked(true);
            // Now submit the form by clicking the button and get back the second page.
            final HtmlPage page2 = button.click();
            List<HtmlElement> elementList = page2.getBody().getElementsByTagName("img");
            boolean result = false;
            for (HtmlElement e : elementList) {
                if (e.getNextSibling()!=null && e.getNextSibling().getTextContent().contains("บันทึกข้อมูลแล้ว")) {
                    result = true;
                }
            }
            if(result){
//                System.out.println("success");
                return result;
            }else {
//                System.out.println("fail");
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Boolean.parseBoolean(null);

//----------------------------------
//        DesiredCapabilities capabilities=DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
        //      if (user != null){
//            WebDriver driver = new FirefoxDriver();

//            HtmlUnitDriver driver = new HtmlUnitDriver();
//            driver.setJavascriptEnabled(true);

//            driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
//            driver.get("https://www.ddteedin.com/register/");

//            driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("Test@hotmail.com");
//            driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("123456");
//            driver.findElement(By.xpath(".//*[@id='password2']")).sendKeys("123456");
//            driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys("Test");
//            driver.findElement(By.xpath(".//*[@id='lastname']")).sendKeys("LastTest");
//            driver.findElement(By.xpath(".//*[@id='mobile']")).sendKeys("0856932569");
//
//            driver.findElement(By.id("accept_term")).click();

//            System.out.println("Title of the page is" + driver.getTitle());

//            driver.findElement(By.id("email")).sendKeys("rrrr");  test
//            driver.findElement(By.id("btSubmit")).click();
//------------------------------

//            WebElement s = driver.findElement(By.xpath(".//*[@id='password']"));
//            s.sendKeys("user.getPass());
//            driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(user.getPass());
//            driver.findElement(By.xpath(".//*[@id='firstname']")).sendKeys(user.getName());

   //     }

    }
    public void loguotUser(){
//        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        try {
            final HtmlPage page1 = webClient.getPage("https://www.ddteedin.com/logout/");
            System.out.println(page1);
            String urlPage = page1.getUrl().toString();
            System.out.println(urlPage);
            if (urlPage.equals("https://www.ddteedin.com/")){
                System.out.println("Success");
            }else{
                System.out.println("Fail");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
