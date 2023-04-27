package pages;


import org.openqa.selenium.By;
import uiAutomationHelper.basePO;

import static Utility.Util.decrypytText;
import static properties.properties.getProperties;

public class Login extends basePO {

    public static String signInRadioButton="//input[@id='sign-in']";
    public static String yourEmail="//input[@id='loginID']";
    public static String password="//input[@id='password']";
    public static String Signin="//button[@data-testid='loginButtonTestId']";

    public String getUserName(){
        String Env= getProperties("config/Controller", "env");
        return getProperties("config/"+Env, "Uname");

    }

    public String getPassword(){
        String Env= getProperties("config/Controller", "env");
        return getProperties("config/"+Env, "PWD");

    }


    public void enterCredential(){
        String Uname=getUserName();
        String Password=getPassword();
        String decryptedPassword=decrypytText(Password);
        findElement(By.xpath(signInRadioButton)).click();
    //        findElement(By.xpath(yourEmail)).sendKeys(Uname);
    //        findElement(By.xpath(Password)).sendKeys(Password);
    //        findElement(By.xpath(Signin)).click();
    }
}
