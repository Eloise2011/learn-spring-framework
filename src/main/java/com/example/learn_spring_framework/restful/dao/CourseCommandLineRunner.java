package com.example.learn_spring_framework.restful.dao;

import com.example.learn_spring_framework.restful.repository.CourseJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-21 11:27
 */
@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.static_insert_records();
        courseJdbcRepository.dynamic_insert_records(new Course(4, "红楼梦", "曹雪芹"));
    }
}
