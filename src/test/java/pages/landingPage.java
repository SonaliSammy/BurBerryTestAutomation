package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uiAutomationHelper.basePO;
import uiAutomationHelper.element;

import java.time.Duration;

public class landingPage extends basePO {
    public static String acceptCookiesButton="//button[@id='onetrust-accept-btn-handler']";
    public static String closePopUpSignUpEmailButton="//div[@data-testid='popup-email-sign-up']/following-sibling::button";
    //public static String womenMenu="//li/a[text()='Women']";
    public static String womenAllClothing="//a[contains(@href,'women')]/span[text()='All Clothing']";
    public static String category="//div//span[text()='Category']";
    public static String menuList="//button[@title='Menu']";
    public static String womenButton="//button[text()='Women']";
    public static String clothing="//button[text()='Clothing']";
    public static String addToBag="//div[text()='Add to bag']//ancestor::button";
    public static String bag="//a[@title='Bag']";
    public static String checkOut="//button[@data-test='shopping-bag__checkout-button']";
    public static String signInRadioButton="//input[@id='sign-in']";
    public static String yourEmail="//input[@id='loginID']";
    public static String password="//input[@id='password']";
    public static String Signin="//button[@data-testid='loginButtonTestId']";


    public  void selectSubMenu(){
        Actions actions= new Actions(getDriver());
        WebElement womenMenu= findElement(By.xpath("//li/a[text()='Women']")).element();
        WebElement womenAllClothing=findElement(By.xpath("//a[contains(@href,'women')]/span[text()='All Clothing']")).element();
        findElement(By.xpath("//li/a[text()='Women']")).highlight();
        getWait().withTimeout(Duration.ofMillis(1000));
        actions.moveToElement(womenMenu).perform();
        findElement(By.xpath("//a[contains(@href,'women')]/span[text()='All Clothing']")).clickJS();


    }


    public static element menu(String menuName){
        return findElement(By.xpath("//li/a[text()='"+menuName+"']"));
    }

    public static element subMenu(String menuName,String subMenuName){
        return findElement(By.xpath("//a[contains(@href,'"+menuName.toLowerCase()+"')]/span[text()='"+subMenuName+"']"));
    }



}
