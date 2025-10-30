package com.example.page;

import com.example.model.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewEmailPage extends MainPage{

  private final String FRAME_LOCATOR = "iframe[id^='mce_'][id$='_ifr']";
  private final String SEND_TO_LOCATOR = "//main//p[@title]/span";
  private final String SEND_BUTTON_LOCATOR = "//button[text()='Надіслати']";

  @FindBy(id = "compose-to")
  private WebElement composeTo;

  @FindBy(id = "compose-subject")
  private WebElement composeSubject;

  @FindBy(id = "tinymce")
  private WebElement composeBody;

  public NewEmailPage(WebDriver driver) {
    super(driver);
  }

  public MainPage send(){
    waitUntilVisible(By.xpath(SEND_BUTTON_LOCATOR)).click();
    return new MainPage(driver);
  }

  public Mail getMail(){
    return new Mail(waitUntilVisible(By.xpath(SEND_TO_LOCATOR)).getText(),
        composeSubject.getAttribute("value"), getBody());
  }

  public NewEmailPage enterMailData(Mail mail){
    waitUntilVisible(composeTo).sendKeys(mail.getComposeTo());
    composeTo.sendKeys(Keys.TAB);
    composeSubject.sendKeys(mail.getComposeSubject());
    composeSubject.sendKeys(Keys.TAB);
    updateBody(mail.getComposeBody());
    return this;
  }

  private void updateBody(String append){
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(FRAME_LOCATOR)));
    composeBody.sendKeys(append);
    composeBody.sendKeys(Keys.TAB);
    driver.switchTo().defaultContent();
  }

  private String getBody(){
    String res;
    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(FRAME_LOCATOR)));
    res = composeBody.getText();
    driver.switchTo().defaultContent();
    return res;
  }
}
