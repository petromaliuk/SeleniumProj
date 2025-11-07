package com.example.page.Basic;

import com.example.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
  protected WebDriver driver;
  protected Waiter shortW;
  protected Waiter longW;

  protected abstract AbstractPage openPage();

  protected AbstractPage(WebDriver driver) {
    this.shortW = Waiter.getShortWaiter(driver);
    this.longW = Waiter.getLongWaiter(driver);
    this.driver = driver;
  }
}
