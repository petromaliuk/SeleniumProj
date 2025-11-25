package com.example.test;

import com.example.model.User;
import com.example.page.*;
import com.example.page.Basic.MailListPage;
import com.example.service.DtoCreator;
import com.example.util.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

public class BaseTest extends CommonConditions{

  private final User user = DtoCreator.userWithCredentialsFromProperty();

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
}
