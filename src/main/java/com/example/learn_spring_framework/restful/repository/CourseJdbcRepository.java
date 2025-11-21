package com.example.learn_spring_framework.restful.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author Joshua.H.Brooks
 * @description
 * @date 2025-11-21 11:19
 */
@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate springJdbcTemplate;

    /**
     * this hard-coded query together with the CommandLineRunner can have this SQL executed when the application is being started.
     */
    String INSERT_QUERY = """
            INSERT INTO course (id, name, author) VALUES(3, 'azure', 'microsoft');
            """;

    public void insert_records() {
        springJdbcTemplate.update(INSERT_QUERY);
    }

}
