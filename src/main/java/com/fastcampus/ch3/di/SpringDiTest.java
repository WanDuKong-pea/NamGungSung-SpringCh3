package com.fastcampus.ch3.di;

import com.fastcampus.ch3.clazz.Car;
import com.fastcampus.ch3.clazz.Door;
import com.fastcampus.ch3.clazz.Engine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDiTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");

        Car car = ac.getBean("car",Car.class);
        Engine engine= ac.getBean("engine",Engine.class);
        Door door = ac.getBean("door",Door.class);

//        car.setColor("red");
//        car.setOil(100);
//        car.setDoor(ac.getBean("door",Door.class));
//        car.setEngine(ac.getBean("engine",Engine.class));

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
        System.out.println("door = " + door);
    }
}
