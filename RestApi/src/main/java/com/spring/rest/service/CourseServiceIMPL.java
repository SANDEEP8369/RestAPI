package com.spring.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.entities.Courses;
@Service

public class CourseServiceIMPL implements CourseService{
	
	List<Courses> list;
	
	public CourseServiceIMPL() {
		
		list=new ArrayList<>();
		list.add(new Courses(123, "Core java", "this course is most imp to learn"));
		list.add(new Courses(345, "Python", "Python is imp for Django "));
	}
	@Override
	public List<Courses> getCourses() {
		
		return list;
	}
	@Override
	public Courses getCourse(long id) {
		Courses c= null;
		
		for(Courses cou:list) {
			if(cou.getId()==id) {
				c=cou;
				break;
			}
		}
		
		return c;
	}
	@Override
	public Courses addCourse(Courses course) {
		
		list.add(course);
		return course;
	}
	@Override
	public Courses updateCourse(Courses course) {
		
		list.forEach(e ->{
			if(e.getId()==course.getId()) {
		       e.setTitle(course.getTitle());
		       e.setDescription(course.getDescription());
			
			}
		});
		return course;
	}
	@Override
	public void deleteCourse(long id) {
		
	list=this.list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
 	}

}
