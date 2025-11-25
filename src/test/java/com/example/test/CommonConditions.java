package com.example.test;

import com.example.driver.DriverSingleton;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Getter
public class CommonConditions {

  protected WebDriver driver;

  @BeforeClass()
  public void setUp() { driver = DriverSingleton.getDriver(); }

  @AfterClass()
  public void stopBrowser() { DriverSingleton.closeDriver(); }

}

