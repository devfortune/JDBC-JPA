package com.mfortune.spr.jdbcandjpa.course;

import com.mfortune.spr.jdbcandjpa.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository repository;

//    @Autowired
//    private CourseJpaRepository repository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(5, "Adam", "Doska"));
        repository.save(new Course(2, "AWS", "Amazon"));
        repository.save(new Course(3, "Azure", "Amazon"));
        repository.deleteById((long) 5);
        System.out.println(repository.findById((long) 2));
        System.out.println(repository.findById((long) 3));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Amazon"));
        System.out.println(repository.findByName("AWS"));
    }
}
