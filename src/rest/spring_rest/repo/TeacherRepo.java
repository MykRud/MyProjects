package com.springrestexample.repo;

import com.springrestexample.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
}
