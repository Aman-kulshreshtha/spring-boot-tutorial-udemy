package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sound.midi.SysexMessage;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDAO studentDao) {
//		Student student = new Student("Bittu","Kulshreshtha","aman@gmail.com");
//
//
//		studentDao.save(student);
//
//		System.out.println("Saved Student details..... Id of newly generated student: "+student.getId());
//
//		System.out.println("Finding student by given id.....");
//
//		Student searchResult = studentDao.findStudentById(student.getId());
//
//		System.out.println("Search Result: " + searchResult);
//
//		System.out.println(studentDao.findStudentByFirstName("Bittu"));

		Student updateStudent = new Student();
		updateStudent.setFirstName("sala");
		updateStudent.setLastName("bala");
		updateStudent.setEmail("lala_bala@gmail.com");

		studentDao.updateStudentById(2,updateStudent);

		studentDao.deleteStudentById(2);


	}

}
