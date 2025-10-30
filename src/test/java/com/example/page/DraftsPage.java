package com.example.page;

import com.example.model.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DraftsPage extends MailListPage{

  public DraftsPage(WebDriver driver) {
    super(driver);
  }

  public NewEmailPage continueWriting(Mail draft){
    waitUntilVisible(getXpathForMail(draft)).click();
    return new NewEmailPage(driver);
  }
}
