package com.example.learn_spring_framework.restful.dao;

import com.fasterxml.jackson.annotation.*;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Joshua.H.Brooks
 * @description This is created for demonstrating the static & dynamic field filtering (implemented via Jackson serializing)
 * @date 2025-11-19 21:00
 */

//@JsonIgnoreProperties({"name","phone"})  //如果这里要ignore number， 应该把card_number加到数组里
@JsonFilter("dynamicFilter") //   暂时注释掉静态过滤的注解： //@JsonIgnoreProperties & //@JsonIgnore
public class BankAccount {
    private String name;
    @JsonProperty("card_number")
    private Long number;
    private String phone;
    //@JsonIgnore
    private String address;
    private int isMasterCard;
    @JsonFormat( pattern="yy-MM-dd")
    @JsonProperty("issue_date")
    private LocalDate date;

    public BankAccount(String name, Long number, String phone, String address, int isMasterCard, LocalDate date) {
        this.name = name;
        this.number = number;
        this.phone = phone;
        this.address = address;
        this.isMasterCard = isMasterCard;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIsMasterCard() {
        return isMasterCard;
    }

    public void setIsMasterCard(int isMasterCard) {
        this.isMasterCard = isMasterCard;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
