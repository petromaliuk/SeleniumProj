package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentPage extends MailListPage {

  public SentPage(WebDriver driver) {
    super(driver);
  }

  private static final Logger log = LoggerFactory.getLogger(SentPage.class);

  public SentPage removeMail(Mail mail) {
      log.info("Remove mail: {}", mail);
    clickMailCheckBox(mail);
    clickToRemoveIcon();
    return this;
  }
}
