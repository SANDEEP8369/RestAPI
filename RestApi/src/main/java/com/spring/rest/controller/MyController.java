package com.spring.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entities.Courses;
import com.spring.rest.service.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService course;
	
	
	//Trial version
	@GetMapping("/home")
	public 	String home()
	{
		return"Welcome to my homepage";
	}
	
	//get All courses
	@GetMapping("/courses")
	public List<Courses> getCourses()
	{
		return this.course.getCourses();
				
		
	}
	//get single course with id
	@GetMapping("/courses/{id}")
	public Courses getCourse(@PathVariable String id) {
		
		return this.course.getCourse(Long.parseLong(id));
	}
	//add course 
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		
		return this.course.addCourse(course);
	}
	//update course with id
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		
		return this.course.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		
		 this.course.deleteCourse(Long.parseLong(id));
	}
	
//	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id){
//		
//		try {
//			this.course.deleteCourse(Long.parseLong(id));
//			return new ResponseEntity<>(HttpStatus.OK);
//		}catch(Exception e) {
//			
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			
//		}
//		
//	}
	
	
	
	
	
	

	

}
