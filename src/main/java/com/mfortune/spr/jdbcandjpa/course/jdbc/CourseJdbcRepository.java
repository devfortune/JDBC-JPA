package com.mfortune.spr.jdbcandjpa.course.jdbc;

import com.mfortune.spr.jdbcandjpa.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class CourseJdbcRepository {
    @Autowired
    JdbcTemplate springJdbcTemplate;
    private static String insertQuery =
            """
                insert into course (id, name, author)
                values(?, ?, ?);
            """;

    private static String deleteQuery =
            """
                delete from course 
                where id = ?
            """;
    // example of Spring JDBC
    private static String selectQuery =
            """
                select * from course 
                where id = ?
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(insertQuery, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long id) {
        springJdbcTemplate.update(deleteQuery, id);
    }

    public Course findById(Long id) {
        return springJdbcTemplate.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Course.class), id);
    }
}
