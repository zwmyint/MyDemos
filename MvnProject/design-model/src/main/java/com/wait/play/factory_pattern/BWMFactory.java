package com.wait.play.factory_pattern;

import com.wait.play.abstract_factory_pattern.ACar;
import com.wait.play.simple_factory_pattern.BWM;

public class BWMFactory implements IFactory {

  public ACar produceCar() {
    return new BWM();
  }
}
