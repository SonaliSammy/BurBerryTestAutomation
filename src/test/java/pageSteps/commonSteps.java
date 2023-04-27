package pageSteps;

import io.cucumber.java.en.Given;

import java.util.Map;

import static driverController.driverManager.initiateDriver;

public class commonSteps {

    @Given("^User opens (.*)$")
    public void Navigate(String app, Map<String,String> param){
        initiateDriver(app,param);
    }
}
