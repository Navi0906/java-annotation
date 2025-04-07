package com.bridgelabz;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
    String status() default "Completed";
}

class TodoTask{

    @Todo(task = "payment",assignedTo = "Madhav",priority = "HIGH",status = "Pending")
    void task1(){

    }

    @Todo(task = "feedback",assignedTo = "Dhruv",priority = "LOW",status = "Pending")
    void task2(){

    }

    @Todo(task = "collections",assignedTo = "Anil")
    void task3(){

    }

}

public class TaskInTodo {
    public static void main(String[] args) throws Exception {
        Class<?> cls = TodoTask.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {

                Todo td = method.getAnnotation(Todo.class);
                if (td.status().equals("Pending")) {
                    System.out.println("Pending Task");
                    System.out.println(method.getName());
                    System.out.println(td.task());
                    System.out.println(td.assignedTo());
                    System.out.println(td.priority());
                    System.out.println();
                }
            }
        }
    }
