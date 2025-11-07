package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import org.openqa.selenium.WebDriver;

public class DraftsPage extends MailListPage {

  public DraftsPage(WebDriver driver) {
    super(driver);
  }

  public NewEmailPage continueWriting(Mail draft){
    openMail(draft);
    return new NewEmailPage(driver);
  }
}
