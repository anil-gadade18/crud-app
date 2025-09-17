package com.springboot.mvc.crud.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mvc.crud.entity.Student;
import com.springboot.mvc.crud.repository.StudentRepository;
import com.springboot.mvc.crud.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository=studentRepository;
	}
	@Override
	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}
	@Override
	public Student addNewStudent(Student student) {
		return this.studentRepository.save(student);
		
	}
	@Override
	public Student getSingleStudentById(Long studentId) {
		
	  return this.studentRepository.findById(studentId).get();
	}
	@Override
	public Student updateStudent(Student student) {
		
		return this.studentRepository.save(student);
	}
	@Override
	public void deleteStudent(Long studentId) {

		this.studentRepository.deleteById(studentId);
	}

}
