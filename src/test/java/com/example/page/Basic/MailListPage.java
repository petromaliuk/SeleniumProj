package com.example.page.Basic;

import com.example.model.Mail;
import com.example.util.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MailListPage extends MainPage {

  private final String FIRST_MAIL_XPATH = "(//div[contains(@class, '_9PrhZH82')])[1]//span";
  private final String CHECKBOX_IN_MAIL_XPATH = ".//input[@type='checkbox']";
  private final String REMOVE_BUTTON_CSS = "button:has(use[*|href*='#icon-remove-0a3a'])";
  private final String THREE_DOTS_BUTTON_CSS = "button:has(use[*|href*='#icon-more-outlined-270d'])";
  private final String MARK_AS_UNREAD_BUTTON_CSS = "div.juTS32E1 button:nth-of-type(2)";

  private By getXpathForMail(Mail mail) {
    return By.xpath("//div[contains(@class, '_9PrhZH82') and .//span[text()='" + mail.getComposeTo() +
        "'] and .//span[text()='" + mail.getComposeSubject() +
        "'] and .//span[text()='" + mail.getComposeBody() + "']]");
  }

  public MailListPage(WebDriver driver) {super(driver);}

  public boolean isPresent(Mail mail){ return shortW.isPresent(getXpathForMail(mail)); }

  public boolean isAbsent(Mail mail){ return shortW.isAbsent(getXpathForMail(mail)); }

  public void clickToRemoveIcon(){
    shortW.waitUntilClickable(By.cssSelector(REMOVE_BUTTON_CSS)).click();
  }

  protected void clickToMarkUnreadButton (){
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
        shortW.waitUntilVisible(By.cssSelector(MARK_AS_UNREAD_BUTTON_CSS)));
  }

  protected void clickToThreeDotsIcon(){
    shortW.waitUntilClickable(By.cssSelector(THREE_DOTS_BUTTON_CSS)).click();
  }

  protected void clickMailCheckBox(Mail mail){
    shortW.waitUntilClickable(getXpathForMail(mail))
        .findElement(By.xpath(CHECKBOX_IN_MAIL_XPATH)).click();
  }

  public Mail getFirstMail(){
    List<WebElement> mail = shortW.waitUntilVisibleElements(By.xpath(FIRST_MAIL_XPATH), 3);
    return new Mail(mail.get(0).getText(), mail.get(1).getText(), mail.get(2).getText());
  }

  public MainPage openMail(Mail mail){
    shortW.waitUntilVisible(getXpathForMail(mail)).click();
    return new MainPage(driver);
  }
}
