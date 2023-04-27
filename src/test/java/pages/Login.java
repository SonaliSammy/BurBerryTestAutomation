package PO;

import Sammy.Properties.Properties;
import Sammy.UIAutomationHelper.BasePO;

import static Utility.Util.decrypytText;

public class Login extends BasePO {

    public String getUserName(String Role){
        String Env= Properties.getProperties("config/Controller", "env");
        return Properties.getProperties("config/"+Env, Role+"_Uname");

    }

    public String getPassword(String Role){
        String Env= Properties.getProperties("config/Controller", "env");
        return Properties.getProperties("config/"+Env, Role+"_PWD");

    }


    public void enterCredential(String Role){
        String Uname=getUserName(Role);
        String Password=getPassword(Role);
        String decryptedPassword=decrypytText(Password);
        findByAI("Email").sendKeys(Uname);
        findByAI("HUDLPassword").sendKeys(decryptedPassword);
        findByAI("HUDLLogin").click();
    }
}
