package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class HomeController {
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String index() {
		return "welcome to crudoperation!!!";
	}

//	handler for creating new records in DB
	@PostMapping("/saveStudent")
	public Student saveDate(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}

//	handler for fetch all a single record
	@GetMapping("/getStudent/{rollNo}")
	public Student getStudentData(@PathVariable int rollNo) {
		Optional<Student> student=studentRepository.findById(rollNo);
		Student student1=student.get();
		return student1;
		
	}
	
	
	
//	handler for fetch all data from DB
	@GetMapping("/getAllStudent")
	public List<Student> getAll() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

//	handler for delete a particular record from DB
	@DeleteMapping("/deleteStudent/{rollNo}")
	public String deleteStudent(@PathVariable int rollNo) {
		Student student = studentRepository.findById(rollNo).get();
		if (student != null)
			studentRepository.delete(student);
		return "Deleted successfully!!!";

	}
//	handler for update a particular record from DB
	@PutMapping("/updateData")
	public Student UpdateStudentData(@RequestBody Student student) {

		studentRepository.save(student);
		return student;

	}

}
