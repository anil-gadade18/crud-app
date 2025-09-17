package com.springboot.mvc.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mvc.crud.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	
}
