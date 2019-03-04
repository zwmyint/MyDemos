package com.wait.play.template_model;

public abstract class TemplateModel {
  protected abstract void step1();
  protected abstract void step2();

  private void basicStep() {
    System.out.println("Basic step...");
  }
  public final void exec() {
    basicStep();
    step1();
    step2();
  }
}
