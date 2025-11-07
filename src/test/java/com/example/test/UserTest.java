package com.example.test;

import com.example.model.Mail;
import com.example.model.User;
import com.example.page.*;
import com.example.page.Basic.MailListPage;
import com.example.page.Basic.MainPage;
import com.example.service.DtoCreator;
import com.example.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserTest extends CommonConditions{

  private User user = DtoCreator.userWithCredentialsFromProperty();

  @BeforeMethod
  public void login(){
    boolean successfulLogin = new LoginPage(driver)
        .openPage()
        .login(user)
        .isLoginSuccessful();
    assertTrue(successfulLogin, "Login failed");
  }
  @AfterMethod
  public void logout(){
    new MailListPage(driver)
        .logout();
    Util.wait(2000);
  }
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
  
  @Test
  public void testFirstMarkAsUnreadAndRead(){
    Mail first = new ReceivedPage(driver)
        .getFirstMail();
    boolean isPresentInUnread1 = new ReceivedPage(driver)
        .markAsUnread(first, "Відмітити непрочитаним")
        .moveToUnread()
        .isPresent(first);
    assertTrue(isPresentInUnread1, "Mail is not present in Unread");
    boolean isAbsentInUnread = new MailListPage(driver)
        .openMail(first)
        .moveToUnread()
        .isAbsent(first);
    assertTrue(isAbsentInUnread, "Mail is present in Unread");
  }

  @Test
  public void testRemoveFirstRemoveForever(){
    Mail first = new MainPage(driver)
        .moveToSent()
        .getFirstMail();
    boolean isPresentInRemoved = new SentPage(driver)
        .removeMail(first)
        .moveToRemoved()
        .isPresent(first);
    assertTrue(isPresentInRemoved, "Mail is not present in Removed");
    boolean isAbsentInRemoved = new RemovedPage(driver)
        .removeForever(first)
        .isAbsent(first);
    assertTrue(isAbsentInRemoved, "Mail is present in Removed after forever deleting");
  }
}
