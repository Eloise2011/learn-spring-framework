package com.example.learn_spring_framework.game;

import org.springframework.stereotype.Component;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-08 16:20
 */
@Component
public class AircraftGame implements GamingConsole{
    public void up(){
        System.out.println("jump jump jump !!!");
    }
    public void down(){
        System.out.println("down into a hole !");
    }
    public void left(){
        System.out.println("Stop !");
    }
    public void right(){
        System.out.println("Accelerate !");
    }
}
