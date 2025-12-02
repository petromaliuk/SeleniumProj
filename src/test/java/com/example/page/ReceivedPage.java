package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReceivedPage extends MailListPage {

    private static final Logger log = LoggerFactory.getLogger(ReceivedPage.class);

  public ReceivedPage(WebDriver driver) { super(driver); }

  public ReceivedPage markAsUnread(Mail mail, String appearedButtonLabel){
      log.info("Mark mail as unread: {}", mail);
    clickMailCheckBox(mail);
    clickToThreeDotsIcon();
    clickToMarkUnreadButton();
    return this;
  }
}
