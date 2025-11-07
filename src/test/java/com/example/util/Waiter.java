package com.example.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
  private static final int SHORT_WAIT_SECONDS = 2;
  private static final int LONG_WAIT_SECONDS = 10;
  private static final int POOLING_EVERY_MILLIS = 500;
  private final FluentWait<WebDriver> wait;

  private Waiter(FluentWait<WebDriver> wait){ this.wait = wait; }

  public static Waiter getShortWaiter(WebDriver driver){
    return new Waiter(new WebDriverWait(driver, Duration.ofSeconds(SHORT_WAIT_SECONDS)));
  }

  public static Waiter getLongWaiter(WebDriver driver){
    return new Waiter(new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(LONG_WAIT_SECONDS))
        .pollingEvery(Duration.ofMillis(POOLING_EVERY_MILLIS))
        .ignoring(NoSuchElementException.class));

  }

  public WebElement waitUntilClickable(By by){ return wait.until(ExpectedConditions.elementToBeClickable(by)); }

  public WebElement waitUntilVisible(By by){return wait.until(ExpectedConditions.visibilityOfElementLocated(by));}

  public WebElement waitUntilVisible(WebElement e){return wait.until(ExpectedConditions.visibilityOf(e));}

  public WebDriver waitUntilFrameToBeAvailableAndSwitchToIy(By by) {
    return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
  }

  public boolean isAbsent(By by){
    try {
      wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
      return true;
    } catch (Exception e) { return false;}
  }

  public boolean isPresent(By by){
    try {
      waitUntilVisible(by);
      return true;
    } catch (Exception e) { return false;}
  }

  public boolean isPresent(WebElement element){
    try {
      waitUntilVisible(element);
      return true;
    } catch (RuntimeException e) {return false;}
  }
}
