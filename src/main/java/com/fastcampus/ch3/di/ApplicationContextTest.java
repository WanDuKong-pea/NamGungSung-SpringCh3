package com.fastcampus.ch3.di;

import com.fastcampus.ch3.clazz.Car;
import com.fastcampus.ch3.clazz.Engine;
import org.springframework.context.*;
import org.springframework.context.support.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * ApplicationContext의 주요 메서드에 대해 알아본다
 */
public class ApplicationContextTest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
//      Car car = ac.getBean("car", Car.class); // 타입을 지정하면 형변환 안해도됨. 아래의 문장과 동일
        Car car  = (Car) ac.getBean("car"); // 이름으로 빈 검색
        Car car2 = (Car) ac.getBean(Car.class);   // 타입으로 빈 검색
        System.out.println("car = " + car);
        System.out.println("car2 = " + car2);

        System.out.println("ac.getBeanDefinitionNames() = " + Arrays.toString(ac.getBeanDefinitionNames())); // 정의된 빈의 이름을 배열로 반환
        System.out.println("ac.getBeanDefinitionCount() = " + ac.getBeanDefinitionCount()); // 정의된 빈의 개수를 반환

        System.out.println("ac.containsBeanDefinition(\"car\") = " + ac.containsBeanDefinition("car"));  // true 빈의 정의가 포함되어 있는지 확인
        System.out.println("ac.containsBean(\"car\") = " + ac.containsBean("car")); // true 빈이 포함되어 있는지 확인

        System.out.println("ac.getType(\"car\") = " + ac.getType("car")); // 빈의 이름으로 타입을 알아낼 수 있음.
        System.out.println("ac.isSingleton(\"car\") = " + ac.isSingleton("car")); // true 빈이 싱글톤인지 확인
        System.out.println("ac.isPrototype(\"car\") = " + ac.isPrototype("car")); // false 빈이 프로토타입인지 확인
        System.out.println("ac.isPrototype(\"door\") = " + ac.isPrototype("door")); // true
        System.out.println("ac.isTypeMatch(\"car\", Car.class) = " + ac.isTypeMatch("car", Car.class)); // "car"라는 이름의 빈의 타입이 Car인지 확인
        System.out.println("ac.findAnnotationOnBean(\"car\", Component.class) = " + ac.findAnnotationOnBean("car", Component.class)); // 빈 car에 @Component가 붙어있으면 반환
        System.out.println("ac.getBeanNamesForAnnotation(Component.class) = " + Arrays.toString(ac.getBeanNamesForAnnotation(Component.class))); // @Component가 붙은 빈의 이름을 배열로 반환
        System.out.println("ac.getBeanNamesForType(Engine.class) = " + Arrays.toString(ac.getBeanNamesForType(Engine.class))); // Engine 또는 그 자손 타입인 빈의 이름을 배열로 반환


        //@Value 추가 기능 Test
        System.out.println("ac.getBean('sysInfo')= "+ac.getBean("sysInfo"));
    }
}

/* [src/main/resources/config.xml]
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>
    <context:component-scan base-package="com.fastcampus.ch3"/>
</beans>
*/

/* [실행 결과]
INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [config.xml]
INFO : org.springframework.context.support.GenericXmlApplicationContext - Refreshing org.springframework.context.support.GenericXmlApplicationContext@5a4aa2f2: startup date [Thu May 11 04:27:19 KST 2023]; root of context hierarchy
INFO : org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor - JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
car = Car{engine=com.fastcampus.ch3.clazz.Engine@45ac5f9b, door=com.fastcampus.ch3.clazz.Door@135606db, color='red', oil=100}
car2 = Car{engine=com.fastcampus.ch3.clazz.Engine@45ac5f9b, door=com.fastcampus.ch3.clazz.Door@135606db, color='red', oil=100}
ac.getBeanDefinitionNames() = [car, door, engine, homeController, org.springframework.context.annotation.internalConfigurationAnnotationProcessor, org.springframework.context.annotation.internalAutowiredAnnotationProcessor, org.springframework.context.annotation.internalRequiredAnnotationProcessor, org.springframework.context.event.internalEventListenerProcessor, org.springframework.context.event.internalEventListenerFactory]
ac.getBeanDefinitionCount() = 9
ac.containsBeanDefinition("car") = true
ac.containsBean("car") = true
ac.getType("car") = class com.fastcampus.ch3.clazz.Car
ac.isSingleton("car") = true
ac.isPrototype("car") = false
ac.isPrototype("door") = true
ac.isTypeMatch("car", Car.class) = true
ac.findAnnotationOnBean("car", Component.class) = @org.springframework.stereotype.Component(value="")
ac.getBeanNamesForAnnotation(Component.class) = [car, door, engine, homeController]
ac.getBeanNamesForType(Engine.class) = [engine]
 */