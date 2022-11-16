package test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/scenarios",
        glue = {"steps"}
)
    public class RunCucumberTest extends AbstractTestNGCucumberTests {
    }


