package com.example.component;

import com.example.util.Waiter;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class Button implements WebElement {

  private static final Logger log = LoggerFactory.getLogger(Button.class);

  @Delegate
  private WebElement element;
  private WebDriver driver;

  @Override
  public void click() { click(Waiter.getDefaultWaiter(driver)); }

  public void click(Waiter waiter) {
    waiter.waitUntilClickable(element);
    element.click();
    log.debug("Button clicked: {}", element);
  }
}
