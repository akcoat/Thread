package com.zhu.testdemo1.dao;


import com.zhu.testdemo1.Entity.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface testDatasource {

    @Select("select * from student")
    List<student>  test();

}
