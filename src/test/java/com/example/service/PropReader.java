package com.example.service;

import java.util.ResourceBundle;

public class PropReader {
  private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("app");

  public static String getTestData(String key){
    return resourceBundle.getString(key);
  }
}
