package com.mike.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		// for singleton, Student object will be created only once after run()
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

		Student student = context.getBean(Student.class);
		System.out.println(student);

		Student student1 = context.getBean(Student.class); // no "Student has been created" again
		System.out.println(student1);
	}

}
