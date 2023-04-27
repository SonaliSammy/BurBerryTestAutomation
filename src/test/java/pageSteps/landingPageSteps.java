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

import static pages.landingPage.*;


public class landingPageSteps extends basePO {

    final static Logger logger = Logger.getLogger(landingPageSteps.class) ;
    landingPage lP= new landingPage();

    @Given("User accepts cookies")
    public void acceptCookies(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.acceptCookiesButton))).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.closePopUpSignUpEmailButton))).click();
    }

    @Given("^User select (.*) menu$")
    public void selectMenu(String menuName){
        getWait().until(ExpectedConditions.visibilityOf(landingPage.menu(menuName).element())).click();
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
    public void userChosesSubMenu(String subMenuName) {
        getWait().withTimeout(Duration.ofMillis(5000));
        landingPage.submenuList(subMenuName).clickJS();
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

        itemQtytext= lP.itemQuantity(item).getText().trim();
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
            lP.item(item).clickJS();
        }
        getWait().withTimeout(Duration.ofMillis(1000));
    }

    @And("^User views (.*) link$")
    public void userViewsProductCardLink(String itemSubType) {
       landingPage.productCard(itemSubType).clickJS();
    }

    @And("^User checks (.*) availability$")
    public void userChecksSizeAvailability(String size) {
        getDriver().manage().window().maximize();
        boolean sizeUnvailable=sizeAvailability(size).getAttribute("class").contains("muted");
        logger.debug("sizeAvailable="+sizeUnvailable);
        runTimeThreadVariable.getInstance().setvalue("sizeAvailable",sizeUnvailable);
    }

    @And("^User picks a (.*) list$")
    public void userPicksASizeList(String sizeName) throws InterruptedException {
        boolean sizeUnavailable= (boolean) runTimeThreadVariable.getInstance().getvalue("sizeAvailable");
        if(!sizeUnavailable){
            size(sizeName).clickJS();
            Thread.sleep(2000);
        }
    }

    @And("User added it to bag")
    public void userAddedItToBag() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.addToBag))).click();
    }

    @And("User checks the bag")
    public void userChecksTheBag() throws InterruptedException {
        Thread.sleep(2000);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.bag))).click();
        Thread.sleep(2000);
    }

    @And("User checkout the item")
    public void userCheckoutTheItem() throws InterruptedException {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.checkOut))).click();
        Thread.sleep(1000);
    }

    @And("^User decides to select unavailable (.*) list$")
    public void userDecidesToSelectUnavailableSizeList(String sizeName) throws InterruptedException {
        size(sizeName).clickJS();
        Thread.sleep(2000);
    }

    @And("User wanted to get notified for the product")
    public void userWantedToGetNotifiedForTheProduct() throws InterruptedException {
        Thread.sleep(2000);
        findElement(By.xpath(landingPage.Notify)).clickJS();
    }
}
