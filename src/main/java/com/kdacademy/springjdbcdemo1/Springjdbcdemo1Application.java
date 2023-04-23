package com.kdacademy.springjdbcdemo1;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kdacademy.springjdbcdemo1.dao.DAO;
import com.kdacademy.springjdbcdemo1.model.Course;

@SpringBootApplication
public class Springjdbcdemo1Application {

	private static DAO<Course> dao ;

	public Springjdbcdemo1Application(DAO<Course> dao){
		this.dao = dao ;
	}
	public static void main(String[] args) {
		SpringApplication.run(Springjdbcdemo1Application.class, args);
		// System.out.println("\n-------------- Create course ----------------\n");
		Course springVue = new Course(6, "Spring Boot+Vue", "New Course", "https://www.crio.do/") ;
		dao.create(springVue);
		System.out.println("\n-------------- Get a Course ----------------\n");
		Optional<Course> firstOne = dao.get(1) ;
		System.out.println(firstOne.get());
		System.out.println("\n-------------- Update a Course ----------------\n");
		springVue.setDesciption("Combined full stack development course");
		dao.update(springVue, 6);
		System.out.println("\n-------------- Delete a Course ----------------\n");
		dao.delete(4);
		System.out.println("\n-------------- All courses ----------------\n");
		List<Course> courses = dao.list() ;
		courses.forEach(System.out::println);
	}

}
