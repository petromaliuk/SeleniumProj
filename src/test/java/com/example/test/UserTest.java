package com.example.test;

import com.example.model.Mail;
import com.example.model.User;
import com.example.page.*;
import com.example.service.DtoCreator;
import com.example.util.Util;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserTest extends CommonConditions{
  @Test
  public void testMailSaveToDraftAndSent(){
    User user = DtoCreator.userWithCredentialsFromProperty();
    Mail mail = DtoCreator.randomMail();
    boolean successfulLogin = new LoginPage(driver)
        .openPage()
        .login(user)
        .isLoginSuccessful();
    assertTrue(successfulLogin, "Login failed");
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
    boolean isDraftPresentSecond = new NewEmailPage(driver)
        .send()
        .moveToDrafts()
        .isPresent(mail);
    assertFalse(isDraftPresentSecond, "Draft is still present in drafts");
    assertTrue(new MainPage(driver)
        .moveToSent()
        .isPresent(mail), "Mail is not present in sent");
    new MailListPage(driver).logout();
    Util.wait(2000);
  }
  @Test
  public void testMailMarkAsUnreadAndRead(){
    User user = DtoCreator.userWithCredentialsFromProperty();
    boolean successfulLogin = new LoginPage(driver)
        .openPage()
        .login(user)
        .isLoginSuccessful();
    assertTrue(successfulLogin, "Login failed");
    Mail first = new ReceivedPage(driver)
        .getFirstMail();
    boolean isPresentInUnread1 = new ReceivedPage(driver)
        .markAsUnread(first)
        .moveToUnread()
        .isPresent(first);
    assertTrue(isPresentInUnread1, "Mail is not present in Unread");
    boolean isPresentInUnread2 = new MailListPage(driver)
        .openMail(first)
        .moveToUnread()
        .isPresent(first);
    assertFalse(isPresentInUnread2, "Mail is present in Unread");
    new MainPage(driver).logout();
    Util.wait(2000);
  }

}
