package com.zhu.testdemo1.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo1 {

    public static void show(myfunctional myfunctional){
        myfunctional.say();
    }

    public static void main(String[] args) {
        // 调用show方法，参数是一个接口，所以可以传递接口的实现类对象
        //  传递匿名内部类
        //调用show方法，方法的参数是一个函数时接口，使用lambda

        List<String> listA = new ArrayList<>();
        listA.add("张三丰");
        listA.add("张建强");
        listA.add("张强");
        listA.add("赵敏");
        listA.add("朱加为");
        /*listA.stream().filter(name->name.startsWith("张"))
                      .filter(name->name.length()==3)
                      .forEach(name->System.out.println(name));*/


        
    }
}
