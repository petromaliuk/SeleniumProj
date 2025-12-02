package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemovedPage extends MailListPage {

  public RemovedPage(WebDriver driver) {super(driver);}

    private static final Logger log = LoggerFactory.getLogger(SentPage.class);

  @FindBy(css = "div._4RMb45M8")
  private WebElement container;

  public RemovedPage removeForever(Mail mail){
      log.info("Remove mail forever: {}", mail);
    clickMailCheckBox(mail);
    clickToRemoveIcon();
    ((JavascriptExecutor) driver).executeScript("arguments[0].querySelector('button').click();", container);
    return this;
  }
}
