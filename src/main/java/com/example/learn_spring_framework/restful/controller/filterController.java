package com.example.learn_spring_framework.restful.controller;

import com.example.learn_spring_framework.restful.dao.BankAccount;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-19 21:27
 */
@RestController
public class filterController {
    @GetMapping("/bank/account")
    public BankAccount staticFilter(){
        return new BankAccount("Josh", 12345678l, "138****138", "BeiJing", 1, LocalDate.now());
    }
    //http://localhost:8085/Yik-learn-spring-framework/dynamic/filter
    @GetMapping("/dynamic/filter")
    public MappingJacksonValue dynamicFilter(){
        BankAccount bankAccount = new BankAccount("Josh", 12345678l, "138****138", "BeiJing", 1, LocalDate.now());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bankAccount);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("card_number","phone");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("dynamicFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic/filter2")
    public MappingJacksonValue dynamicFilter2(){
        BankAccount bankAccount = new BankAccount("Josh", 12345678l, "138****138", "BeiJing", 1, LocalDate.now());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bankAccount);
        PropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("address","card_number","phone");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("dynamicFilter",filter);
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
