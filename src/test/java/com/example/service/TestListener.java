package com.example.service;

import com.example.test.CommonConditions;
import com.example.util.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {



  @Override
  public void onTestFailure(ITestResult result) {
    Object testClass = result.getInstance();
    WebDriver driver = ((CommonConditions) testClass).getDriver(); // get driver from base class

    String testName = result.getName();
    ScreenshotUtil.takeScreenshot(driver, testName);

    System.out.println("📸 Screenshot captured for failed test: " + testName);
  }
}
