package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.WebDriver;

public class SentPage extends MailListPage {

  public SentPage(WebDriver driver) {
    super(driver);
  }

  public SentPage removeMail(Mail mail) {
    clickMailCheckBox(mail);
    clickToRemoveIcon();
    return this;
  }
}
