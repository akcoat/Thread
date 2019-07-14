package com.zhu.testdemo1.lambda;

import com.zhu.testdemo1.Entity.student;

public class demo2 {

    public static void testMethodRefer(myfunctional myfunctional){
        myfunctional.say();
    }

    public static void main(String[] args) {
        //testMethodRefer(()->System.out.println("helloworld"));
        // java 中引用类型的赋值 是值传递
        student s = new student();
        s.setTeacher_id("1");
        student ss = new student();
        ss.setTeacher_id("2");
        student dd =s;
        s=ss;
        System.out.println(dd.getTeacher_id());

    }
}
