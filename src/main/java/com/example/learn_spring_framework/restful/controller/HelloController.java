package com.example.learn_spring_framework.restful.controller;

import com.example.learn_spring_framework.restful.dao.User;
import com.example.learn_spring_framework.restful.exception.NoUserFoundException;
import com.example.learn_spring_framework.restful.service.UserService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-17 21:04
 */
@RestController
public class HelloController {

    private MessageSource messageSource;

    public HelloController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/hello")
     public String hello(){
         return "Hello World !";
     }
    @GetMapping("/hello/i18n")
    public String helloI18n(){
        Locale locale = LocaleContextHolder.getLocale();
        /**
         * 第一个参数是要获取变量的 key
         * 第二个参数是如果 value 中有占位符，可以从这里传递参数进去
         * 第三个参数传递一个 Locale 实例即可，这相当于当前的语言环境。
         */
        return messageSource.getMessage("i18n.greetings", null, "Default Message", locale);
    }
}
