package stepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/Users/praveenag/eclipse-workspace/API_RestAssured/src/test/resources/Features/cucumberAPI.feature",
        glue= "stepDefinition",
   
        plugin = {   "pretty",
				"html:target/cucumber-reports/cucumber.html"
                 },
        	
        monochrome = true
         
)

public class TestRunner  {
	 

}
 