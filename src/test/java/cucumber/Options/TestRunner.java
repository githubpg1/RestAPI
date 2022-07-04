package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", // no need to provide the file name since there is only one file
														// present

		glue = "stepDefinations", tags = "@DeletePlace" // in maven -> mvn test -Dcucumber.options="--tags @addPlace"

		, plugin = "json:target/jsonReports/cucumber-report.json") // your reports will be saved here. ,Maven cucumber
																	// reporting

public class TestRunner {

}
