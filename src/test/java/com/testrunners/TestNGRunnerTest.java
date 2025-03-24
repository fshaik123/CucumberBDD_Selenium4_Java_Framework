package com.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com", "com/AppHooks"},
        plugin = {"message:target/cucumber-report.json", "pretty", "html:target/cucumber.html"})
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
}