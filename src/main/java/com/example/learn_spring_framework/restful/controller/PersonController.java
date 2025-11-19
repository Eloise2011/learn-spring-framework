package com.example.learn_spring_framework.restful.controller;

import com.example.learn_spring_framework.restful.dao.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-19 20:02
 */
@RestController
public class PersonController {
    // URL versioning
    //http://localhost:8085/Yik-learn-spring-framework/URL/versioning/v1/person
    @GetMapping("URL/versioning/v1/person")
    public Person URLVersioningPersonV1(){
        return new Person("Jackson Wang");
    }
    @GetMapping("URL/versioning/v2/person")
    public Person URLVersioningPersonV2(){
        return new Person("Jay","Chou");
    }
    // Request Param Versioning
    //http://localhost:8085/Yik-learn-spring-framework/param/versioning/person?version=1
    @GetMapping(value = "param/versioning/person", params = "version=1")
    public Person paramVersioningPersonV1(){
        return new Person("Andy Lau");
    }
    @GetMapping(value = "param/versioning/person", params="version=2")
    public Person paramVersioningPersonV2(){
        return new Person("德华","刘");
    }

    @GetMapping(value = "header/versioning/person", headers="my-app-Version=1")
    public Person headerVersioningPersonV1(){
        return new Person("曹操");
    }
    @GetMapping(value = "header/versioning/person", headers="my-app-Version=2")
    public Person headerVersioningPersonV2(){
        return new Person("孟德","曹");
    }

    @GetMapping(value = "produces/versioning/person", produces="application/vnd.api-v1+json") // produces  里的值除了“v1”， 其他是固定写死的
    public Person producesVersioningPersonV1(){
        return new Person(" 关羽");
    }

    @GetMapping(value = "produces/versioning/person", produces="application/vnd.api-v2+json")
    public Person producesVersioningPersonV2(){
        return new Person("云长","关");
    }

}
