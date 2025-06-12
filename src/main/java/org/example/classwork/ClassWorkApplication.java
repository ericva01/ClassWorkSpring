package org.example.classwork;

import org.example.classwork.model.Students;
import org.example.classwork.services.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClassWorkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassWorkApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo (StudentService studentService){
		return args -> {
			System.out.println("=".repeat(10)+ "All Students"+ "=".repeat(10));
			studentService.getAllStudents().forEach(System.out::println);

			System.out.println("=".repeat(10)+ "Insert New Student"+ "=".repeat(10));
			Students newStudent = new Students(11,"Lili",60.0,"Male");
			studentService.addStudent(newStudent);
			studentService.getAllStudents().forEach(System.out::println);

			System.out.println("=".repeat(10)+ "Find Student By ID"+ "=".repeat(10));
			studentService.getStudentById(3).ifPresent(System.out::println);

			System.out.println("=".repeat(10)+ "Update Student By Id"+ "=".repeat(10));
			Students updatedStudent = new Students(1,"Wen Hao Ran",80.0,"Male");
			boolean update =  studentService.updateStudent(1,updatedStudent);
			System.out.println("Updated Student: "+ update +"Successfully");

			System.out.println("=".repeat(10)+ "Delete Student By ID"+ "=".repeat(10));
			boolean deleteStudent = studentService.deleteStudent(3);
			System.out.println("Deleted Student: "+ deleteStudent +"Successfully");

		};
	}
}
