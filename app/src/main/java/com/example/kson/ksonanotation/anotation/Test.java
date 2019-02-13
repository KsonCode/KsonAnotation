package com.example.kson.ksonanotation.anotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args){
        //第一步
        Class<User> userClass = User.class;

        //第二步，获取不同元素的注解
        MyAnotation myAnotation = userClass.getAnnotation(MyAnotation.class);
        if (myAnotation!=null){
            System.out.println(myAnotation.userId());;
        }

        //获取域的
        try {
            Field field = userClass.getField("name");
            MyAnotation myAnotation1 = field.getAnnotation(MyAnotation.class);
            System.out.println(myAnotation1.userId());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            Method method = userClass.getDeclaredMethod("fun",null);
            method.setAccessible(true);

            MyAnotation myAnotation1 = method.getAnnotation(MyAnotation.class);
            if (myAnotation1!=null){
                System.out.println( myAnotation1.userId());
               ;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
