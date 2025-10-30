package com.example.page;

import com.example.model.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailListPage extends MainPage{
  public MailListPage(WebDriver driver) {
    super(driver);
  }
  public boolean isPresent(Mail mail){
    return isPresent(getXpathForMail(mail));
  }

  public MainPage openMail(Mail mail){
    waitUntilVisible(getXpathForMail(mail)).click();
    return new MainPage(driver);
  }

  protected By getXpathForMail(Mail mail) {
    return By.xpath("//div[contains(@class, '_9PrhZH82') and .//span[text()='" + mail.getComposeTo() +
        "'] and .//span[text()='" + mail.getComposeSubject() +
        "'] and .//span[text()='" + mail.getComposeBody() + "']]");
  }
}
