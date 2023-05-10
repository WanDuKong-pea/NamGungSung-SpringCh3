package com.fastcampus.ch3.diCopy1;

import com.fastcampus.ch3.clazz.Car;
import com.fastcampus.ch3.clazz.Truck;

public class Main3 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();

        Car carName = (Car)ac.getBean("car");
        Car carType1 = (Car)ac.getBean(Car.class);
        Car carType2 = (Car)ac.getBean(Truck.class);

        System.out.println("carName = " + carName);
        System.out.println("carType1 = " + carType1);
        System.out.println("carType2 = " + carType2);
    }
}
