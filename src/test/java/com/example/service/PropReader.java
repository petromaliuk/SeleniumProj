package com.example.service;

import java.util.ResourceBundle;

public class PropReader {
  private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("env"));

  public static String getTestData(String key){
    return resourceBundle.getString(key);
  }
}
