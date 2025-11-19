package com.example.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-08 16:20
 */
@Component
@Primary
public class MarioGame implements GamingConsole{
    public void up(){
        System.out.println("up !");
    }
    public void down(){
        System.out.println("down !");
    }
    public void left(){
        System.out.println("left !");
    }
    public void right(){
        System.out.println("right !");
    }
}
