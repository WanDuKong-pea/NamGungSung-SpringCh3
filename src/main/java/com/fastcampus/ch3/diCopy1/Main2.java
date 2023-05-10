package com.fastcampus.ch3.diCopy1;

import com.fastcampus.ch3.clazz.Car;
import com.fastcampus.ch3.clazz.Engine;

public class Main2 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car");
        Engine engine = (Engine)ac.getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }
}
