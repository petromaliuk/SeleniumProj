package com.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

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

  public MainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  @Override
  public AbstractPage openPage() {
    return null;
  }

  public boolean isLoginSuccessful(){
    return isPresent(credentialBlock);
  }

  public LoginPage logout(){
    waitUntilVisible(credentialBlock).click();
    waitUntilVisible(By.xpath(LOGOUT_BUTTON_XPATH)).click();
    return new LoginPage(driver);
  }
  public NewEmailPage writeNewMail(){
    waitUntilVisible(writeMailButton).click();
    return new NewEmailPage(driver);
  }
  public DraftsPage moveToDrafts(){
    waitUntilVisible(draftsButton).click();
    return new DraftsPage(driver);
  }
  public MailListPage moveToSent(){
    waitUntilVisible(sentButton).click();
    return new MailListPage(driver);
  }
  public ReceivedPage moveToReceived(){
    waitUntilVisible(receivedButton).click();
    return new ReceivedPage(driver);
  }

  public MailListPage moveToUnread(){
    waitUntilVisible(unreadButton).click();
    return new MailListPage(driver);
  }
}
