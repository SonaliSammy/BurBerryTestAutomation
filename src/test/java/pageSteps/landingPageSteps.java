package pageSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.landingPage;
import uiAutomationHelper.basePO;

import java.time.Duration;

import static pages.landingPage.menu;


public class landingPageSteps extends basePO {

    landingPage lP= new landingPage();

    @Given("User accepts cookies")
    public void acceptCookies(){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.acceptCookiesButton))).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.closePopUpSignUpEmailButton))).click();
    }

    @Given("^User select (.*) menu$")
    public void selectMenu(String menuName){
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='"+menuName+"']"))).click();

        int itemQty= lP.itemSize("Jeans");
        if(itemQty>0){
            lP.item("Jeans").click();
        }
        lP.productCardLink("Jeans").clickJS();
        getDriver().manage().window().maximize();
        if(findElement(By.xpath("//input[@value='"+"22"+"']/parent::label")).getAttribute("class").contains("muted")){
            findElement(By.xpath("//input[@value='22']")).click();
        }
        findElement(By.xpath("//input[@value='30']")).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.addToBag))).click();
        getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(landingPage.bag))).click();

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
    public void userClickOnCategory() {
        findElement(By.xpath(landingPage.category)).click();
    }
}
