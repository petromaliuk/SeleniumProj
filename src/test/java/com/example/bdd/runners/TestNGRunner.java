package com.example.bdd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.example.bdd.steps", "com.example.bdd.hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}