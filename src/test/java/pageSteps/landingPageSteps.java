package pageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.landingPage;
import runTimeVariable.runTimeThreadVariable;
import uiAutomationHelper.basePO;

import java.time.Duration;

import static pages.landingPage.menu;


public class landingPageSteps extends basePO {

    final static Logger logger = Logger.getLogger(landingPageSteps.class) ;

    @Given("User accepts cookies")
    public void acceptCookies(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.acceptCookiesButton))).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.closePopUpSignUpEmailButton))).click();
    }

    @Given("^User select (.*) menu$")
    public void selectMenu(String menuName){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='"+menuName+"']"))).click();
    }


    @Given("^User navigates to menuList")
    public void userNavigatesToMenuList() {
        if(!findElement(By.xpath(landingPage.menuList)).element().isDisplayed()) {
            Dimension currentDimension= getDriver().manage().window().getSize();
            Dimension dimension=new Dimension(currentDimension.getWidth()/2,currentDimension.getHeight());
            getDriver().manage().window().setSize(dimension);
        }
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.menuList))).click();

    }

    @And("^User choses (.*)$")
    public void userChosesSubMenu(String subMenu) {
        getWait().withTimeout(Duration.ofMillis(5000));
        findElement(By.xpath("//a[contains(@href,'women')]/span[text()='"+subMenu+"']")).clickJS();
    }

    @And("User click on Category")
    public void userClickOnCategory() throws InterruptedException {
        findElement(By.xpath(landingPage.category)).click();
        Thread.sleep(1000);
    }

    @And("^User get itemQuantity for the (.*)$")
    public void userGetItemQuantity(String item) {
        int itemQty = 0;
        String itemQtytext;
        getWait().withTimeout(Duration.ofMillis(3000));
        if(findElements(By.xpath("//div[text()='"+item+"]'/following-sibling::div")).size()>1){
            itemQtytext=findElements(By.xpath("//div[text()='"+item+"']/following-sibling::div")).get(0).getText().trim();
        }else{
            itemQtytext=findElement(By.xpath("//div[text()='"+item+"']/following-sibling::div")).getText().trim();
        }
        logger.debug("itemQTy= "+itemQtytext);
        if(itemQtytext.length()>0){
            itemQty=Integer.parseInt(itemQtytext.substring(1,itemQtytext.length()-1));
        }
        runTimeThreadVariable.getInstance().setvalue("itemQty",itemQty);
    }

    @And("^User selected (.*) only if it is available$")
    public void userSelectedItemOnlyIfItIsAvailable(String item) {
        int itemQty=  Integer.parseInt(runTimeThreadVariable.getInstance().getvalue("itemQty").toString());
        if(itemQty>0){
            if(findElements(By.xpath("//div[text()='"+item+"']")).size()>1){
                findElements(By.xpath("(//div[text()='"+item+"'])")).get(0).clickJS();
            }else{
                findElement(By.xpath("(//div[text()='"+item+"'])")).clickJS();
            }
        }
        getWait().withTimeout(Duration.ofMillis(1000));
    }

    @And("^User views (.*) link$")
    public void userViewsProductCardLink(String itemSubType) {
        findElement(By.xpath("//a[contains(@aria-label,'"+itemSubType+"')]")).clickJS();
    }

    @And("^User checks (.*) availability$")
    public void userChecksSizeAvailability(String size) {
        getDriver().manage().window().maximize();
        boolean sizeUnvailable=findElement(By.xpath("//input[@value='"+size+"']/parent::label")).getAttribute("class").contains("muted");
        logger.debug("sizeAvailable="+sizeUnvailable);
        runTimeThreadVariable.getInstance().setvalue("sizeAvailable",sizeUnvailable);
    }

    @And("^User picks a (.*) list$")
    public void userPicksASizeList(String size) throws InterruptedException {
        boolean sizeUnavailable= (boolean) runTimeThreadVariable.getInstance().getvalue("sizeAvailable");
        if(!sizeUnavailable){
            findElement(By.xpath("//input[@value='"+size+"']")).clickJS();
            Thread.sleep(2000);
        }
    }

    @And("User added it to bag")
    public void userAddedItToBag() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add to bag']//ancestor::button"))).click();
    }

    @And("User checks the bag")
    public void userChecksTheBag() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Bag']"))).click();
    }

    @And("User checkout the item")
    public void userCheckoutTheItem() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='shopping-bag__checkout-button']"))).click();
    }
}
