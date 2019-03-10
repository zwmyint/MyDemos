package com.wait.play.abstract_factory;

public class FactoryB extends AFactory {

  @Override
  public ACar produceCar() {
    return new BWM();
  }

  @Override
  public ATv produceATv() {
    return new SaumTv();
  }
}
