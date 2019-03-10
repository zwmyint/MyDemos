package com.wait.play.factory_model;

import com.wait.play.abstract_factory.ACar;
import com.wait.play.simple_factory_model.BWM;

public class BWMFactory implements IFactory {

  public ACar produceCar() {
    return new BWM();
  }
}
