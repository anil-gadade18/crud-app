package com.springboot.mvc.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.mvc.crud.entity.Student;
import com.springboot.mvc.crud.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/list")
	public String showAllStudents(Model model) {
		List<Student> allStudents = this.studentService.getAllStudents();
		model.addAttribute("students", allStudents);
		return "student-list";
	}
	
	@GetMapping("/createStudent")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		
		if(result.hasErrors()) {
			return "student-form";
		}
		
		this.studentService.addNewStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("/updateStudentForm/{studentId}")
	public String updateStudent(@PathVariable("studentId") Long studentId, Model model) {
		
		Student student = this.studentService.getSingleStudentById(studentId);
		model.addAttribute("student", student);
		return "student-edit";
	}
	
	@PostMapping("/updateStudent")
	public String updatedStudent(@ModelAttribute("student") Student student) {
		
		this.studentService.updateStudent(student);
		return "redirect:/students/list";
	}
	
	@GetMapping("/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable("studentId") Long studentId) {
		
		this.studentService.deleteStudent(studentId);
		return "redirect:/students/list";
	}
}

