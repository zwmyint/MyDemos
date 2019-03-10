package com.wait.play.simple_factory_model;

import com.wait.play.abstract_factory.ACar;

public class SimpleFactory {

  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ACar getCarByType() {
    if ("BWM".equals(this.type)) {
      return new BWM();
    } else if ("Audio".equals(this.type)) {
      return new Audio();
    } else {
      return null;
    }
  }
}
