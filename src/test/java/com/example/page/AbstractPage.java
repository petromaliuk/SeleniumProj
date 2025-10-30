package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
  protected WebDriver driver;
  protected final int WAIT_TIMEOUT_SECONDS = 3;
  protected final WebDriverWait wait;

  protected abstract AbstractPage openPage();

  protected WebElement waitUntilPresent(By by){
    return wait.until(ExpectedConditions.presenceOfElementLocated(by));
  }

  protected WebElement waitUntilVisible(By by){
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }
  protected WebElement waitUntilVisible(WebElement element){
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected boolean isPresent(By by){
    try {
      waitUntilVisible(by);
      return true;
    } catch (Exception e) { return false;}
  }

  protected boolean isPresent(WebElement element){
    try {
      waitUntilVisible(element);
      return true;
    } catch (RuntimeException e) {return false;}
  }
  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
  }
}
