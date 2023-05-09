package com.fastcampus.ch3.diCopy1.clazz;

public class Car {
    //[기존 iv 등록]
    //Application ac = new Application
    //Engine engine = (Engine)ac.getBean("engine");
    //Door door = (Door) ac.getBean("Door");

    //[@Autowired 사용]
    //ApplicatonContext에 저장되어 있는 객체를 타입으로 찾아서 자동으로 연결해줌
    //@Autowired Engine engine;
    //@Autowired Door door;

    //[@Autowired vs @Resource vs @Component]
    //@Autowired는 ApplicationContext에 저장되어있는 객체를 타입으로 찾아 iv와 매핑해주는것
    //@Resource는 @Autowired와 기능이 같지만 ApplicationContext에서 객체를 이름으로 찾아 매핑
        //@Resource(name="클래스의 첫글자를 소문자로 바꾼 값이 사용됨")
        //name 생략 가능
    //@Component는 클래스를 ApplicationContext에 생성 등록해주는 것
}
