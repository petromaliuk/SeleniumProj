package com.example.bdd.hooks;

import com.example.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    public static WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}