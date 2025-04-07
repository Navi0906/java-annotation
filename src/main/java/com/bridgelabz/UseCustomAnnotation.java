package com.bridgelabz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority() default "medium";
    String assignedTo();
}

class TaskManager{
    @TaskInfo(priority = "high",assignedTo = "Madhav")
    public void payment(){
        System.out.println("Payment");
    }

    @TaskInfo(assignedTo = "Dhruv")
    public void feedback(){
        System.out.println("Feedback");
    }
}

public class UseCustomAnnotation {
    public static void main(String[] args) throws Exception{
        Class<?> cls = TaskManager.class;
        Method[] methods = cls.getMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(TaskInfo.class)){
                TaskInfo t1 = method.getAnnotation(TaskInfo.class);
                System.out.println(method.getName());
                System.out.println(t1.priority());
                System.out.println(t1.assignedTo());
            }
        }
    }
}
