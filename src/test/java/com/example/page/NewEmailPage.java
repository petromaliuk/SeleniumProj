package com.example.page;

import com.example.model.Mail;
import com.example.page.Basic.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewEmailPage extends MainPage {

  private final String FRAME_CSS = "iframe[id^='mce_'][id$='_ifr']";
  private final String SEND_TO_CSS = "span[class*='-a0Ll+ku']";
  private final String SEND_BUTTON_CSS = "button.c5RN4yNv.RwpIv5iy.ebrCxt3c";

    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

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
      log.info("Mail send");
    shortW.waitUntilVisible(By.cssSelector(SEND_BUTTON_CSS)).click();
    return new MainPage(driver);
  }

  public Mail getMail(){
      Mail mail = new Mail(shortW.waitUntilVisible(By.cssSelector(SEND_TO_CSS)).getText(),
              composeSubject.getAttribute("value"), getBody());
      log.info("Read mail from fields: {}", mail);
    return mail;
  }

  public NewEmailPage enterMailData(Mail mail){
      log.info("Enter mail data: {}", mail);
    shortW.waitUntilVisible(composeTo).sendKeys(mail.getComposeTo());
    composeTo.sendKeys(Keys.TAB);
    composeSubject.sendKeys(mail.getComposeSubject());
    composeSubject.sendKeys(Keys.TAB);
    updateBody(mail.getComposeBody());
    return this;
  }

  private void updateBody(String append){
    longW.waitUntilFrameToBeAvailableAndSwitchToIy(By.cssSelector(FRAME_CSS));
    composeBody.sendKeys(append);
    composeBody.sendKeys(Keys.TAB);
    driver.switchTo().defaultContent();
  }

  private String getBody(){
    String res;
    longW.waitUntilFrameToBeAvailableAndSwitchToIy(By.cssSelector(FRAME_CSS));;
    res = composeBody.getText();
    driver.switchTo().defaultContent();
    return res;
  }
}
