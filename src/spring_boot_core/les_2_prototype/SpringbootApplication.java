package com.mike.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		// for prototype, Student object will not be created after run()
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);

		// there Student object will be created
		Student student = context.getBean(Student.class); // "Student has been created"
		System.out.println(student);

		// and there again Student object will be created
		Student student1 = context.getBean(Student.class); // "Student has been created" again
		System.out.println(student1);
	}

}
