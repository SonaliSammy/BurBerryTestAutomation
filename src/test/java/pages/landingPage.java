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

    public static String womenAllClothing="//a[contains(@href,'women')]/span[text()='All Clothing']";
    public static String category="//div//span[text()='Category']";
    public static String menuList="//button[@title='Menu']";
    public static String womenButton="//button[text()='Women']";
    public static String clothing="//button[text()='Clothing']";
    public static String addToBag="//div[text()='Add to bag']//ancestor::button";
    public static String bag="//a[@title='Bag']";
    public static String checkOut="//button[@data-test='shopping-bag__checkout-button']";
    public static String Notify="//button[@aria-label='notifyInStockButton-aria-label']";





    public static element menu(String menuName){
        return findElement(By.xpath("//button[text()='"+menuName+"']"));
    }

    public static element submenuList(String submenuName){
        return findElement(By.xpath("//a[contains(@href,'women')]/span[text()='"+submenuName+"']"));
    }

    public static element productCard(String item){
        return findElement(By.xpath("//a[contains(@aria-label,'"+item+"')]"));
    }

    public element itemQuantity(String item){
        element itemQuantity;
        if(findElements(By.xpath("//div[text()='"+item+"]'/following-sibling::div")).size()>1){
            itemQuantity=findElements(By.xpath("//div[text()='"+item+"']/following-sibling::div")).get(0);
        }else{
            itemQuantity=findElement(By.xpath("//div[text()='"+item+"']/following-sibling::div"));
        }
        return itemQuantity;

    }

    public element item(String itemName){
        element item;
        if(findElements(By.xpath("//div[text()='"+itemName+"']")).size()>1){
            item=findElements(By.xpath("(//div[text()='"+itemName+"'])")).get(0);
        }else{
            item=findElement(By.xpath("(//div[text()='"+itemName+"'])"));
        }
        return item;
    }

    public static element sizeAvailability(String size){
        return findElement(By.xpath("//input[@value='"+size+"']/parent::label"));
    }

    public static element size(String sizeName){
        return findElement(By.xpath("//input[@value='"+sizeName+"']"));
    }




}
