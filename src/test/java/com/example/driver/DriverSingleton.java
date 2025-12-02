package com.example.driver;

import com.example.service.PropReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverSingleton {

  private static final Logger log = LoggerFactory.getLogger(DriverSingleton.class);
  private static WebDriver driver;

  public static WebDriver getDriver() {
    if (driver == null) {
      driver = DriverFactory.create(PropReader.getTestData("browser"));
      driver.manage().window().maximize();
      log.debug("Driver has been created");
    }
    return driver;
  }

  public static void closeDriver() {
    driver.quit();
    driver = null;
    log.debug("Driver has been closed");
  }
}
