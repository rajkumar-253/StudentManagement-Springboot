package com.spring.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.students.repository.StudentRepository;
import com.spring.students.students.Student;

@SpringBootApplication
public class StudentManagementApplication {
	
	@Autowired
	public StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	

}
