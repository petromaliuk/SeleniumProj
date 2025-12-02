package com.example.page;

import com.example.component.Button;
import com.example.model.User;
import com.example.page.Basic.AbstractPage;
import com.example.page.Basic.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage {

  private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

  private final String PAGE_URL = "https://mail.ukr.net/";

  @FindBy(id = "id-text-field-0")
  private WebElement inputLogin;

  @FindBy(id = "id-text-field-1")
  private WebElement inputPassword;

  @FindBy(xpath = "//button[text()='Продовжити']")
  private WebElement buttonSubmit;


  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(this.driver, this);
  }

  @Override
  public LoginPage openPage() {
      log.info("Login page open");
    driver.navigate().to(PAGE_URL);
    return this;
  }

  public LoginPage enterUsernameAndPassword(String username, String password){
      log.info("Login enter username and password");
      inputLogin.sendKeys(username);
      inputPassword.sendKeys(password);
      return this;
  }

  public MainPage pressSubmitButton() {
      log.info("Login submit button press");
    new Button(buttonSubmit, driver).click();
    return new MainPage(driver);
  }
  public MainPage login(User user){
      enterUsernameAndPassword(user.getUsername(), user.getPassword());
      return pressSubmitButton();
  }
}
