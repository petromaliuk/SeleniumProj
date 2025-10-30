package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Mail {

  private String composeTo;
  private String composeSubject;
  private String composeBody;
}
