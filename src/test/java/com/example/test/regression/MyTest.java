package com.example.test.regression;

import com.example.model.Mail;
import com.example.page.Basic.MailListPage;
import com.example.page.Basic.MainPage;
import com.example.page.ReceivedPage;
import com.example.page.RemovedPage;
import com.example.page.SentPage;
import com.example.test.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class MyTest extends BaseTest {

  @Test
  public void testFirstMarkAsUnreadAndRead() {
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
  public void testRemoveFirstRemoveForever() {
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
