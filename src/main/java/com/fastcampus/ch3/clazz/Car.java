package com.fastcampus.ch3.clazz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Car {
    //@Autowired
    Engine engine;
    //@Autowired
    Door door;

    //@Value()는 @Component 빈 자동 등록 시
    //iv 값을 초기화 해줄 수 있는 애노테이션
    //@Value("red")
    String color;
    //@Value("100")
    int oil;

    public Car() {
    }

    //생성자가 하나일 경우에 @Autowired 생략 가능
    @Autowired //생성자 주입 방법
    public Car(Engine engine, Door door, @Value("red") String color, @Value("100") int oil) {
        this.engine = engine;
        this.door = door;
        this.color = color;
        this.oil = oil;
    }

    //config.xml의 property 태그는 setter 메서드를 사용하기에 필요함
    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                ", color='" + color + '\'' +
                ", oil=" + oil +
                '}';
    }



    //[기존 iv 등록]
    //Application ac = new Application
    //Engine engine = (Engine)ac.getBean("engine");
    //Door door = (Door) ac.getBean("Door");

    //[@Autowired 사용]
    //ApplicatonContext에 저장되어 있는 객체를 타입으로 찾아서 자동으로 연결해줌
        //Autowired 특징 -> 타입으로 먼저 찾고 찾은 객체가 여러개인 경우 이름으로 찾음
    //@Autowired Engine engine;
    //@Autowired Door door;

    //[@Autowired vs @Resource vs @Component]
    //@Autowired는 ApplicationContext에 저장되어있는 객체를 타입으로 찾아 iv와 매핑해주는것
    //@Resource는 @Autowired와 기능이 같지만 ApplicationContext에서 객체를 이름으로 찾아 매핑
        //@Resource(name="클래스의 첫글자를 소문자로 바꾼 값이 사용됨")
        //name 생략 가능
    //@Component는 클래스를 ApplicationContext에 생성 등록해주는 것
        //@Autowired는 @Component 애노테이션이 붙은 경우에 사용 가능함


    //[@Qualifier() 애노테이션]
    //같은 타입을 가진 객체가 빈으로 여러개 등록되어 있을 때
    //ex) @Component SuperEngine extends Engine{};,@Component TurboEngine extends Engine{};
    //후보 중 사용할 객체의 명을 명시해 줄 수 있음
    //@Qualifier("superEngine") Engine engine;
    //@Autowired와 같은 역할을 함

    //주로 타입 검색인 @Autowired를 사용
    //이름이 바뀔 가능성이 높기 때문
}