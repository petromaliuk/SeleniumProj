package com.example.page.Basic;

import com.example.util.Waiter;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
  protected WebDriver driver;
  protected Waiter shortW;
  protected Waiter longW;

  protected AbstractPage(WebDriver driver) {
    this.shortW = Waiter.getDefaultWaiter(driver);
    this.longW = Waiter.getLongWaiter(driver);
    this.driver = driver;
  }

  protected abstract AbstractPage openPage();
}
