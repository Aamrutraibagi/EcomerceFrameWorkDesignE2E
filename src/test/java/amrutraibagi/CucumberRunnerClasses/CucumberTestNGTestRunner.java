package amrutraibagi.CucumberRunnerClasses;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/amrutraibagi/CucumberFeature",glue="amrutraibagi/CucumberStepDefinationClass"
,monochrome=true,tags="@Functional",plugin= {"html:target/cucumber.html"})
public class CucumberTestNGTestRunner extends AbstractTestNGCucumberTests{

}
