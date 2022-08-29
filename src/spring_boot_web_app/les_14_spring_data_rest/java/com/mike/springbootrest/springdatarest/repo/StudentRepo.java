package com.mike.springbootrest.springdatarest.repo;

import com.mike.springbootrest.springdatarest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
