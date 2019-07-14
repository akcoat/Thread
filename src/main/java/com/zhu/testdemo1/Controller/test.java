package com.zhu.testdemo1.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {


        // 将String json格式数据转为jsonobject
        String jsonStr2="{\"name\":\"zhangsan\",\"age\":12}";
        JSONObject jo = JSON.parseObject(jsonStr2);
        // 将map转为json数据
        Map map = new HashMap();
        map.put("t1","k1");
        map.put("t2","k2");
        String jsonStr1 = JSON.toJSONString(map);
        //System.out.println(jsonStr1);
        //将数组类型的json字符串 转为JSONArray对象
        String jsonStr=
                "[{\"name\":\"zhangsan\",\"age\":11},{\"like\":\"soccer\"}]";
        JSONArray ja = JSON.parseArray(jsonStr);
        for(int i=0;i<ja.size();i++){
            JSONObject res = ja.getJSONObject(i);
            System.out.println
                    ("name:="+res.getString("name")+"age:="+res.getString("age"));
        }

        /**
         * 第三种情况：比较复杂的json数据格式：例如：
         * {
         *    "name":"zhaoyun",
         *    "age":666,
         *    "school":{
         *              "schoolName":"家里蹲",
         *              "schoolCode":110
         *             },
         *    "teacher":[
         *                {
         *                 "mathTecherName":"刘备",
         *                 "mathTeacherAge":54
         *                },
         *                {
         *                 "englishTeacherName":"关羽",
         *                 "englishTeacherAge":110
         *                }
         *            ]
         * }
         *
         */
        String jsonStr3=
                "{\"name\":\"zhaoyun\",\"age\":666,\"school\":{\"schoolName\":\"家里蹲\",\"schoolCode\":\"110\"},\"teacher\":[{\"mathTecherName\":\"刘备\",\"mathTeacherAge\":54},{\"mathTecherName\":\"关羽\",\"mathTeacherAge\":110}]}";

        JSONObject jsonObject1 = JSON.parseObject(jsonStr3);
        JSONArray jsonArray = jsonObject1.getJSONArray("teacher");
        for(int j=0;j<jsonArray.size();j++){
            JSONObject JS = jsonArray.getJSONObject(j);
            System.out.println(JS.getString("mathTecherName"));
            System.out.println(JS.getString("mathTeacherAge"));
        }

    }




}
