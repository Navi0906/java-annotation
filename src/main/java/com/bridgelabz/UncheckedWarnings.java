package com.bridgelabz;


import java.util.*;

@SuppressWarnings("unchecked")
public class UncheckedWarnings {
    public static void main(String[] args) {
        List arr = new ArrayList();
        arr.add(13);
        arr.add(15);
        arr.add("strimg");
        arr.add(true);

        for(Object obj : arr){
            System.out.println(obj);
        }
    }
}
