package com.spring.students.service;

import java.util.List;

import com.spring.students.students.Student;

public interface IStudentService {
	
	List<Student> getStudents();
	
	Student findStudnet(Long id);
	
	void deleteStudent(Long id);
	
	Student updateStudent(Student student,Long id);
	
	Student addStudnet(Student student);

}
