package com.zhu.testdemo1.Controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhu.testdemo1.Entity.student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/distribute")
@Slf4j
public class Distribute {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JedisPool jedisPool;



    @PostMapping("/test1")
    public Map test1(@RequestBody String data){
       System.out.println("------------------test1---------------------");
        log.info(data);
        System.out.println("------------------test1---------------------");
        Map map = new HashMap();
        map.put("code",200);
        return map;
    }


    @PostMapping("/test2")
    public Map test2(@RequestBody String data){
        System.out.println("------------------test2---------------------");
        log.info(data);
        System.out.println("------------------test2---------------------");
        Map map = new HashMap();
        map.put("code",200);
        return map;
    }


    @GetMapping("/test")
    public String  sendData(){
        // 设置参数
        student student = new student();
        student.setId("1");
        student.setName("lisi");
        student.setTeacher_id("2");
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
       // httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        httpHeaders.setContentType(type);
        httpHeaders.set("account","123445");
        httpHeaders.set("secret","33333");
        String stu = JSON.toJSONString(student);
       HttpEntity<String> httpEntity = new HttpEntity(stu,httpHeaders);
       //  第一个参数是 url。第二个参数是传输的请求头和请求体，第三个参数是预期的返回类型
        ResponseEntity result =
                restTemplate.postForEntity
                        ("http://localhost:8080/test", httpEntity,Object.class);

        Object body = result.getBody();
        String test = JSON.toJSONString(body);
        System.out.println(test);
       /* HttpStatus statusCode = result.getStatusCode();
        boolean xxSuccessful = statusCode.is2xxSuccessful();
        log.info("statusCode:{}",xxSuccessful);
        result.getHeaders();

        HttpEntity body = result.getBody();
        String test = (String)body.getBody();
        System.out.println(test);
        log.info("body:{}",body.toString());*/
       /* JSONObject jsonObject = JSON.parseObject(body.toString());
        String msg = jsonObject.getString("msg");
        log.info("msg:{}",msg);*/
        return "hello-world";
    }
}
