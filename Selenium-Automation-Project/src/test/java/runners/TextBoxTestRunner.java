package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features= {"src/test/java/features/TextBoxTestinginTestLeaf.feature"},
					glue="stepDefinitions",
					dryRun = !true,
					monochrome=true,
					plugin= {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"})
public class TextBoxTestRunner extends AbstractTestNGCucumberTests{

}
