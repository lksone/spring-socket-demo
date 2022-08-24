package org.example.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lks
 * @E-mail 1056224715@qq.com.
 * @Since 1.0
 * @Date 2022/8/23 22:43
 */
public class Test {

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("name", "小绵羊");
        //方法名 赋值不同调用不同方法


        String name="test2";
        try {
            Class<Test> test= Test.class;
            //Map是参数类型
            Method methods=test.getMethod(name, Map.class);
            //调用方法 返回object 可以进行强转
            methods.invoke(new Test(),params);
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            e.printStackTrace();
        }
    }
    public Map<String, Object> test1( Map<String, Object> map) {
        System.out.println("我是test1"+map.get("name"));
        return map;
    }
    public Map<String, Object> test2( Map<String, Object> map) {
        System.out.println("我是test2"+map.get("name"));
        return map;
    }
    public Map<String, Object> test3( Map<String, Object> map) {
        System.out.println("我是test3"+map.get("name"));
        return map;
    }
}
