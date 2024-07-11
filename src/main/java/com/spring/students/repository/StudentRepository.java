package com.spring.students.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.students.students.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
