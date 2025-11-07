package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.WebDriver;

public class ReceivedPage extends MailListPage {

  public ReceivedPage(WebDriver driver) { super(driver); }

  public ReceivedPage markAsUnread(Mail mail, String appearedButtonLabel){
    clickMailCheckBox(mail);
    clickToThreeDotsIcon();
    clickToMarkUnreadButton();
    return this;
  }
}
