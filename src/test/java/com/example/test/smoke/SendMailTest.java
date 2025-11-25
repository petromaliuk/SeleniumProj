package com.example.test.smoke;

import com.example.model.Mail;
import com.example.model.User;
import com.example.page.*;
import com.example.page.Basic.MailListPage;
import com.example.page.Basic.MainPage;
import com.example.service.DtoCreator;
import com.example.test.BaseTest;
import com.example.test.CommonConditions;
import com.example.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SendMailTest extends BaseTest {

  @Test
  public void testMailSaveToDraftAndSent(){
    Mail mail = DtoCreator.randomMail();
    boolean isDraftPresent = new MainPage(driver)
        .writeNewMail()
        .enterMailData(mail)
        .moveToDrafts()
        .isPresent(mail);
    assertTrue(isDraftPresent, "Draft is not present in drafts");
    Mail received = new DraftsPage(driver)
        .continueWriting(mail)
        .getMail();
    assertEquals(received, mail, "Mails are different");
    boolean isDraftAbsent = new NewEmailPage(driver)
        .send()
        .moveToDrafts()
        .isAbsent(mail);
    assertTrue(isDraftAbsent, "Draft is still present in drafts");
    assertTrue(new MainPage(driver)
        .moveToSent()
        .isPresent(mail), "Mail is not present in sent");
  }
}
