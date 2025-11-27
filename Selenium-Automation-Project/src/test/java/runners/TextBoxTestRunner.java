package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( features= {"./src/test/resources/features/TextBoxTestinginTestLeaf.feature"},
					glue="stepDefinitions",
					dryRun = !true,
					monochrome=true,
					publish = false,
					plugin= {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"},
					tags = ("@Test,"
							+ "@Test1")
)
public class TextBoxTestRunner extends AbstractTestNGCucumberTests{

}
