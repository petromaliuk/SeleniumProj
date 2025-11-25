package com.example.driver;

import com.example.service.PropReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {

  private static final Logger log = LoggerFactory.getLogger(DriverFactory.class);

  public static WebDriver create(String browser) {
    switch (PropReader.getTestData("browser")){
      case "firefox": {
        WebDriverManager.firefoxdriver().setup();
        log.info("firefox webdriver creating");
        return new FirefoxDriver();
      }
      case "edge": {
        WebDriverManager.edgedriver().setup();
        log.info("edge webdriver creating");
        return new EdgeDriver();
      }
      case "chrome": {
        WebDriverManager.chromedriver().setup();
        log.info("chrome webdriver creating");
        return new ChromeDriver();
      }
      default:
        throw new IllegalArgumentException("Unknown browser: " + browser);
    }
  }
}
