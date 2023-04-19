package Runner;


//https://www.youtube.com/watch?v=2YBEFV4DFxo
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

@RunWith(JUnitPlatform.class)
//@IncludeTags(value= {"Smoke1","Smoke2"})
//@ExcludeTags(value= {"Smoke3"})
/*
@CucumberOptions(
		features = "classpath:features/Nationality.feature"
		,glue={"stepDefinition"}
		,tags= {"@Smoke","@Regression"}
		
		)*/

@CucumberOptions(
        //features="src/test/resources/Feature",
		//  tags = "@SmokeTest and @End2End"
		features = "classpath:features/Nationality.feature",
        glue={"SeleniumGludeCode1"},
        tags=("@Smoke"),
        monochrome = true,
                plugin= {"pretty", "junit:target/JUNITReports/report.xml",
                 "json:target/JSONResports/report.json",
                 "html:target/HTMLReports/report.html",
                 "html:target/cucumber-reports/Cucumber.html"},
        dryRun=true
        )

public class testrunner4 {
    
}



