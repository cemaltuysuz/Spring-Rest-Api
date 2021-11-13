package com.cemaltuysuz.springRestApi;

import com.cemaltuysuz.springRestApi.entity.Student;
import com.cemaltuysuz.springRestApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApiApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
	Student student = new Student();
	student.setName("cemal");
	student.setLastName("tuysuz");
	student.setAge(21);
	studentRepository.save(student);

	Student student2 = new Student();
	student2.setName("kadir");
	student2.setLastName("aktar");
	student2.setAge(21);
	studentRepository.save(student2);

	Student student3 = new Student();
	student3.setName("emin");
	student3.setLastName("çakmak");
	student3.setAge(21);
	studentRepository.save(student3);
	}
}
