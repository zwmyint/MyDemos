package com.wait.play.abstract_factory_pattern;

public class FactoryA extends AFactory {

  @Override
  public ACar produceCar() {
    return new Audio();
  }

  @Override
  public ATv produceATv() {
    return new SonyTv();
  }
}
