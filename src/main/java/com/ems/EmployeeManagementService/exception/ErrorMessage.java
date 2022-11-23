package com.ems.EmployeeManagementService.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Setter
@Getter
@ToString
public class ErrorMessage {
  private int statusCode;

  private String code;
  private Date timestamp;
  private String message;
  private String description;
  private String source;
  public ErrorMessage(int statusCode, Date timestamp, String message, String description) {
    this.statusCode = statusCode;
    this.timestamp = timestamp;
    this.message = message;
    this.description = description;
  }

  public ErrorMessage(String code, Date timestamp, String message, String source) {
    this.code = code;
    this.timestamp = timestamp;
    this.message = message;
    this.source = source;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }
}