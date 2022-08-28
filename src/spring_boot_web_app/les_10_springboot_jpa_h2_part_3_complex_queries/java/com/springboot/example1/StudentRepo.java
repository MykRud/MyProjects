package com.springboot.example1;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findByAge(int age);

    List<Student> findByIdLargerThan(int age);

    @Query("FROM Student WHERE age>?1 ORDER BY name")
    List<Student> findByAgeSorted(int age);
}
