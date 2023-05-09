package com.fastcampus.ch3.diCopy1;

import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppContext {
    //객체 저장소
    Map map;

    /**
     * Properties로 config.txt 파일을 읽어와서 String,String으로 담은 다음
     * map에 String,Object로 직접 객체를 생성해서 담아주었음
     *
     * @Component
     * -> 클래스 앞에 @Component를 사용하면 객체를 생성해서 map에 저장해줌.
     * -> (스프링 부트에서 ApplicationContext 에 자동 등록 됨, 노션에 정리해둠)
     */
    AppContext() throws Exception{

        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        //properties에 저장된 키와 값들이 HashMap에 복사됨
        map = new HashMap(p);

        //HashMap 객체에 저장된 모든 키에 대해 반복문을 수행
        //이때 key는 HashMap 객체의 각 키를 의미
        for(Object key : map.keySet()){
            //String,String으로 되어 있던 properties를 복사해서 담은 map을
            //객체를 생성해서 map의 String,Object로 바꿈
            //즉 객체를 생성해서 map에 다시 넣어줌
            Class clazz = Class.forName((String)map.get(key));
            map.put(key,clazz.newInstance());
        }
    }

    /**
     * 이름 객체 이름으로 Bean 찾기
     */
    Object getBean(String key){return map.get(key);}

    /**
     * 객체 타입으로 Bean 찾기
     */
    Object getBean(Class clazz){
        for(Object obj : map.values()){
            if(clazz.isInstance(obj)){
                return obj;
            }
        }
        return null;
    }
}
