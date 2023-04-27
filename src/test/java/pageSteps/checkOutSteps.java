package pageSteps;

import io.cucumber.java.en.And;
import pages.Login;

public class checkOutSteps {
    Login login=new Login();
    @And("User signed in")
    public void userSignedIn() {
        login.enterCredential();
    }
}
