package com.spring.rest.service;

import java.util.List;

import com.spring.rest.entities.Courses;

public interface CourseService {
	
	public List<Courses> getCourses();

   public Courses getCourse(long id);
   
   public Courses addCourse(Courses course);
   
   public Courses updateCourse(Courses course);
   
   public void deleteCourse(long id);
}
