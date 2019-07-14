package com.zhu.testdemo1.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class student  implements Serializable {


    private String id;

    private String name;

    private String teacher_id;

}
