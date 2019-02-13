package com.example.kson.ksonanotation.anotation;

import java.security.PublicKey;

@MyAnotation(userId = "class",age = 100)
public class User {
    @MyAnotation(userId = "name",age = 100)
    public String name;
    public int age;

    @MyAnotation(userId = "fun",age = 100)
    private void fun(){

    }

    public void fun2(@Query("mobile") String s,@Query( "pwd") String pwd){

    }


}
