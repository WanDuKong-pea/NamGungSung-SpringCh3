package com.fastcampus.ch3.diCopy1;

import com.fastcampus.ch3.clazz.Car;

import java.io.FileReader;
import java.util.Properties;

/**
 * 변경에 유리한 코드를 작성해보자
 * 다형성을 이용.
 */
public class Main1 {
    public static void main(String[] args) throws Exception{
        Car car = (Car) getObject();
        //Engine engine = (Engine)getObject();
        System.out.println("car = " + car);
    }

    static Object getObject() throws Exception{
        //config.txt를 읽어서 Properties에 저장
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));


        //클래스 객체(설계도)를 얻어서
        Class clazz = Class.forName(p.getProperty("car"));
        //Class clazz = Class.forName(p.getPropertu("engine"));
        return clazz.newInstance(); //객체를 생성해서 반환
    }
}
