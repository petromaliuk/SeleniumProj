package com.example.page;

import com.example.model.Mail;
import com.example.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ReceivedPage extends MailListPage {

  private final String FIRST_MAIL_XPATH = "//div[contains(@class, '_9PrhZH82')]";
  private final String MARK_AS_UNREAD_BUTTON_XPATH = "//button[text()='Відмітити непрочитаним']";

  @FindBy(xpath = "//div[@class='sdkvIRpe']//button[last()]")
  private WebElement threeDotsButton;

  public ReceivedPage(WebDriver driver) { super(driver); }

  public ReceivedPage markAsUnread(Mail mail){
    waitUntilVisible(getXpathForMail(mail)).findElement(By.xpath("//input[@type='checkbox']")).click();
    threeDotsButton.click();
    waitUntilPresent(By.xpath(MARK_AS_UNREAD_BUTTON_XPATH)).click();
    return this;
  }
  public Mail getFirstMail(){
    List<WebElement> list = waitUntilVisible(By.xpath(FIRST_MAIL_XPATH)).findElements(By.tagName("span"));
    return new Mail(list.get(0).getText(), list.get(1).getText(), list.get(2).getText());
  }
}
