package com.example.learn_spring_framework.restful.service;

import com.example.learn_spring_framework.restful.dao.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-17 19:02
 */
@Component
public class UserService {

    private static List<User> userList = new ArrayList<>();

    private static int count;

    static {
        userList.add(new User(++count, "Josh", LocalDate.now().minusYears(30)));
        userList.add(new User(++count, "Yik", LocalDate.now().minusYears(1)));
        userList.add(new User(++count, "Jasmine", LocalDate.now().minusYears(25)));
    }

    public List<User> findAllUsers(){
        return userList;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = predicateById(id);
        //return userList.stream().filter(predicate).findFirst().get();
        return userList.stream().filter(predicate).findFirst().orElse(null); // if there, return it. If not, return null
    }

    public User deleteOne(int id) {
        User one = findOne(id);
        userList.removeIf(predicateById(id));
        return (null == one)?null:one;
    }

    private Predicate<? super User> predicateById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return predicate ;
    }

    public User save(User user) {
        user.setId(++count);
        userList.add(user);
        return user;
    }
}
