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
     public element item(String itemName){
        element item = null;
        if(findElements(By.xpath("//div[text()='"+itemName+"']")).size()>1){
            item=findElements(By.xpath("(//div[text()='"+itemName+"'])")).get(0);
        }else{
            item=findElement(By.xpath("(//div[text()='"+itemName+"'])"));
        }
        return item;
     }

    public int itemSize(String itemName){
        int itemSize ;
        if(findElements(By.xpath("//div[text()='"+itemName+"]'/following-sibling::div")).size()>1){
            itemSize=Integer.parseInt(findElements(By.xpath("(//div[text()='"+itemName+"'])")).get(0).getText().substring(1,findElement(By.xpath("//div[text()='"+itemName+"']/following-sibling::div")).getText().length()-1));
        }else{
            itemSize=Integer.parseInt(findElement(By.xpath("//div[text()='"+itemName+"']/following-sibling::div")).getText().trim().substring(1,findElement(By.xpath("//div[text()='"+itemName+"']/following-sibling::div")).getText().trim().length()-1));
        }
        return itemSize;
    }

    public element productCardLink(String itemName){
        return findElement(By.xpath("//a[contains(@aria-label,'"+itemName+"')]"));
    }





}
