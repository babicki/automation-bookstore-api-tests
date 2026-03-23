package com.example.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Cucumber test runner for running BDD scenarios.
 * Loads all feature files and links them with step definitions.
 *
 * Uses JUnit to run the tests. Feature files are in
 * src/test/resources/features. Step definitions are in
 * com.example.stepdefinitions.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.stepdefinitions",
        plugin = {"pretty"}//,
//        tags = "@"
)
public class TestRunner {
}

