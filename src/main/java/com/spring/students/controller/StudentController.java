package com.spring.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.students.service.IStudentService;
import com.spring.students.service.StudentServiceImpl;
import com.spring.students.students.Student;

@Controller
public class StudentController {
	
	@Autowired
	private IStudentService studenService;
	
	@GetMapping("/students")
	public String studentsList(Model model) {
		List<Student> students = studenService.getStudents();
		for(Student stu : students) {
			System.out.println(stu.getFirstName());
		}
		model.addAttribute("studentsKey", students);
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studenService.addStudnet(student);
		return "redirect:/students";
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable("id") Long id,Model model) {
		Student student = studenService.findStudnet(id);
		model.addAttribute("student",student);
		return "edit_form";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@ModelAttribute("student") Student student,@PathVariable("id") Long id) {
		studenService.updateStudent(student, id);
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studenService.deleteStudent(id);
		return "redirect:/students";
	}
	

}
