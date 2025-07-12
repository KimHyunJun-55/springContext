package star.springexam.exam;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ApplicationContext {
    Map<String, Object> objMap;
    Properties props;
    public ApplicationContext(){
        props = new Properties();
        objMap = new HashMap<>();
        try {
            props.load(new FileInputStream(("src/main/resources/Beans.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        props.getProperty("book1");

    }

    public Object getBean(String id) throws Exception {

        Object obj = objMap.get(id);
        if(obj != null){
            return obj;
        }else{
            String className = props.getProperty(id);
            //class name 에 해당하는 문자열을 가지고 인스턴스를 생성할 수 있다.
            Class<?> clazz = Class.forName(className);
            //Method[] methods = clazz.getMethods();
            Method[] methods = clazz.getDeclaredMethods();
            //for(Method m : methods){
            //System.out.println(m.getName());
            //}
            Object o = clazz.getDeclaredConstructor().newInstance();
            objMap.put(id,o);
            obj = objMap.get(id);

            return obj;


        }



    }
}
