package Utility;

import Sammy.Reporter.BDDReport;
import Sammy.RunTimeVariable.ThreadVariable;
import Sammy.UIAutomationHelper.BasePO;
import Sammy.UIAutomationHelper.Element;
import org.jasypt.util.text.BasicTextEncryptor;

import java.time.Duration;

public class Util extends BasePO {

    private Element element=null;
    static BasicTextEncryptor encryptor= new BasicTextEncryptor();


    public void takeScreenshot(Element el){
      this.element=el;
      el.Highlight();
      getSmartDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
      String currentStepDescr= ThreadVariable.getInstance().getvalue("CurrentStep").toString();
      BDDReport.addBase64ImageFromPath("Pass",currentStepDescr,false,getSmartDriver());
      el.RemoveHighlight();
    }

    public static String decrypytText(String stringToBeDecrypted){
        encryptor.setPasswordCharArray("NCJFCTeamMember1_PWD".toCharArray());
       return encryptor.decrypt(stringToBeDecrypted);
    }
}
