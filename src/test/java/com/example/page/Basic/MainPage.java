package com.example.page.Basic;

import com.example.page.DraftsPage;
import com.example.page.LoginPage;
import com.example.page.NewEmailPage;
import com.example.page.ReceivedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage extends AbstractPage {

  private static final String LOGOUT_BUTTON_XPATH = "//button[text()='Вийти з акаунта']";

  @FindBy(xpath = "//div[contains(@class, 'p9AQfHXy')]")
  private WebElement credentialBlock;

  @FindBy(xpath = "//button[text()='Написати листа']")
  private WebElement writeMailButton;

  @FindBy(xpath = "//a[@title='Чернетки']")
  private WebElement draftsButton;

  @FindBy(xpath = "//a[@title='Надіслані']")
  private WebElement sentButton;

  @FindBy(xpath = "//a[@title='Вхідні']")
  private WebElement receivedButton;

  @FindBy(xpath = "//a[@title='Непрочитані']")
  private WebElement unreadButton;

  @FindBy(xpath = "//a[@title='Видалені']")
  private WebElement removedButton;

    private static final Logger log = LoggerFactory.getLogger(MainPage.class);

  public MainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  @Override
  public AbstractPage openPage() {
    return null;
  }

  public boolean isLoginSuccessful(){
    return shortW.isPresent(credentialBlock);
  }

  public LoginPage logout(){
      log.debug("Click to ");
    shortW.waitUntilVisible(credentialBlock).click();
    shortW.waitUntilVisible(By.xpath(LOGOUT_BUTTON_XPATH)).click();
    return new LoginPage(driver);
  }
  public NewEmailPage writeNewMail(){
    shortW.waitUntilVisible(writeMailButton).click();
    return new NewEmailPage(driver);
  }
  public DraftsPage moveToDrafts(){
    shortW.waitUntilVisible(draftsButton).click();
    return new DraftsPage(driver);
  }
  public MailListPage moveToSent(){
    shortW.waitUntilVisible(sentButton).click();
    return new MailListPage(driver);
  }
  public ReceivedPage moveToReceived(){
    shortW.waitUntilVisible(receivedButton).click();
    return new ReceivedPage(driver);
  }

  public MailListPage moveToUnread(){
    shortW.waitUntilVisible(unreadButton).click();
    return new MailListPage(driver);
  }

  public MailListPage moveToRemoved(){
    shortW.waitUntilVisible(removedButton).click();
    return new MailListPage(driver);
  }

}
