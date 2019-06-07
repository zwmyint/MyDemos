package com.wait.play.model;

public class TravelViewObject {

  private String userId;
  private String source;
  private String destination;

  public TravelViewObject() {
  }

  public TravelViewObject(String userId, String source, String destination) {
    this.userId = userId;
    this.source = source;
    this.destination = destination;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }
}
