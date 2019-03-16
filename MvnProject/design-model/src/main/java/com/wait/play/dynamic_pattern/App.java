package com.wait.play.dynamic_pattern;

import java.lang.reflect.Proxy;

public class App {

  public static void main(String[] args) {
    AiQiYi aiQiYi = new AiQiYi();
    MyProxy aiQiYiMyProxy = new MyProxy(aiQiYi);

    IVedio iVedio = (IVedio)aiQiYiMyProxy.getProxyInstance();
    iVedio.start("xiao zhu peiqi");
    iVedio.end("xiao zhu peiqi");


    System.out.println("================================");
    YouKu youKu = new YouKu();
    MyProxy youKuMyProxy = new MyProxy(youKu);

    iVedio = (IVedio)youKuMyProxy.getProxyInstance();
    iVedio.start("xiao ma ban li");
    iVedio.end("xiao ma ban li");


  }

}
