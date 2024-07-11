package com.spring.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.students.repository.StudentRepository;
import com.spring.students.students.Student;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student findStudnet(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		Student updateStudent = findStudnet(id);
		updateStudent.setEmail(student.getEmail());
		updateStudent.setFirstName(student.getFirstName());
		updateStudent.setLastName(student.getLastName());
		return studentRepository.save(updateStudent);
	}

	@Override
	public Student addStudnet(Student student) {
		return studentRepository.save(student);
	}

}
