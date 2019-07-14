package com.zhu.testdemo1;

import com.zhu.testdemo1.Entity.student;
import com.zhu.testdemo1.dao.testDatasource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testdemo1ApplicationTests {

    @Autowired
    private testDatasource testDatasource;


    @Test
    public void contextLoads() {

        List<student> list = testDatasource.test();
        System.out.println(list.get(0).getId());

    }

}
