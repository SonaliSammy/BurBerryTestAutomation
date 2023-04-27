package Runner;


import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import runTimeVariable.runTimeThreadVariable;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings({"unused", "deprecation"})
@CucumberOptions(
        plugin = {"reporter.extentCucumberAdapter:"},
        features = {"classpath:features"},
        glue = {"pageSteps",
                "Runner"},
        tags = "@Order"


)

public class TestRunner extends AbstractTestNGCucumberTests{
    private int currentStepDefIndex = 0;
    String  currentStepDescr = null;
    String  prevStepDescr=null;








    /**
     * Returns two-dimensional array of PickleEventWrapper scenarios with their associated CucumberFeatureWrapper feature.*/
    @Override
    // @DataProvider(parallel = true)
    @DataProvider
    public Object[][] scenarios() {
        return super.scenarios();
    }



    @AfterStep
    public void getStep(Scenario scenario) throws Exception {
        currentStepDefIndex++;

        Field delegateField= scenario.getClass().getDeclaredField("delegate");
        delegateField.setAccessible(true);

        TestCaseState testCaseState=((TestCaseState) delegateField.get(scenario));
        Field TestCaseField= testCaseState.getClass().getDeclaredField("testCase");
        TestCaseField.setAccessible(true);

        TestCase testCase=(TestCase) TestCaseField.get(testCaseState);


        Field testSteps = testCase.getClass().getDeclaredField("testSteps");
        testSteps.setAccessible(true);

        List<PickleStepTestStep> teststeps  = testCase.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());


        try {
            PickleStepTestStep PreviousstepDefs=null;
            if(currentStepDefIndex<teststeps.size()){
                PickleStepTestStep stepDefs = teststeps.get(currentStepDefIndex);
                currentStepDescr= stepDefs.getStepText();
                runTimeThreadVariable.getInstance().setvalue("CurrentStep", currentStepDescr);
            }

            if((currentStepDefIndex-1)>0 & currentStepDefIndex<teststeps.size()){
                PreviousstepDefs = teststeps.get(currentStepDefIndex-1);
            }


            if(PreviousstepDefs!=null){
                prevStepDescr= PreviousstepDefs.getStepText();
                runTimeThreadVariable.getInstance().setvalue("PreviousStep", prevStepDescr);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }













}
