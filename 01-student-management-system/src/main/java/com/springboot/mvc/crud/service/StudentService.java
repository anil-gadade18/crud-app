package com.springboot.mvc.crud.service;

import java.util.List;

import com.springboot.mvc.crud.entity.Student;

public interface StudentService {

	
	public List<Student> getAllStudents();
	public Student addNewStudent(Student student);
	public Student getSingleStudentById(Long studentId);
	public Student updateStudent(Student student);
	public void deleteStudent(Long studentId);
}
