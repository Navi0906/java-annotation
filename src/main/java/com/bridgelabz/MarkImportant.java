package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Important{
    String level() default "HIGH";
}

class Tasks{
    @Important
    void task1(){
        System.out.println("Task 1");
    }
    void task2(){
        System.out.println("Task 2");
    }
}

public class MarkImportant {
    public static void main(String[] args) throws Exception{
        Class<?> cls = Tasks.class;
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.isAnnotationPresent(Important.class)){
                Important imp = method.getAnnotation(Important.class);
                System.out.println(method.getName());
                //System.out.println(cls.getDeclaredConstructor().newInstance());
                System.out.println("Level: "+imp.level());
            }
        }
    }
}
