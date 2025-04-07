package com.bridgelabz;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports{
    BugReport[] value();
}

class Bug{
    @BugReport(description = "bug-report1")
    @BugReport(description = "bug-report2")

    void bug1(){
        System.out.println("Madhav");
    }

    @BugReport(description = "bug-report3")
    void bug2(){
        System.out.println("Dhruv");
    }
}

public class PrintBugReports {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Bug.class;
        Method[] methods = cls.getDeclaredMethods();

        for(Method method : methods){
            if(method.isAnnotationPresent(BugReports.class)){
                BugReports report = method.getAnnotation(BugReports.class);
                for(BugReport bug : report.value()){
                    System.out.println(method.getName());
                    System.out.println(method.invoke(cls.getDeclaredConstructor().newInstance()));
                    System.out.println(bug.description());
                }
            } else if (method.isAnnotationPresent(BugReport.class)) {
                BugReport report = method.getAnnotation(BugReport.class);
                System.out.println(method.getName());
                System.out.println(report.description());
            }
        }
    }
}
