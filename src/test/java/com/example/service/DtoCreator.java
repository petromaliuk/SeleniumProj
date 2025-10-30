package com.example.service;

import com.example.model.Mail;
import com.example.model.User;
import com.example.util.Util;

public class DtoCreator {

  public static final String TESTDATA_USER_NAME = "testdata.user.name";
  public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
  public static final String TESTDATA_RECEIVER = "testdata.receiver";

  public static User userWithCredentialsFromProperty(){
    return new User(PropReader.getTestData(TESTDATA_USER_NAME), PropReader.getTestData(TESTDATA_USER_PASSWORD));
  }
  public static Mail randomMail(){
    return new Mail(PropReader.getTestData(TESTDATA_RECEIVER), Util.generateRandomString(20),
        Util.generateRandomString(30));
  }

}
