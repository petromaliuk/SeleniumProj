package com.example.page;

import com.example.model.User;
import com.example.page.Basic.AbstractPage;
import com.example.page.Basic.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

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
    driver.navigate().to(PAGE_URL);
    return this;
  }

  public MainPage login(User user) {
    inputLogin.sendKeys(user.getUsername());
    inputPassword.sendKeys(user.getPassword());
    buttonSubmit.click();
    return new MainPage(driver);
  }
}
