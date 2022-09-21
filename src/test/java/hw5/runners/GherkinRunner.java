package hw5.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/hw5.features/GherkinTest.feature"},
        glue = {"hw5.steps"}
)
public class GherkinRunner extends AbstractTestNGCucumberTests {
}