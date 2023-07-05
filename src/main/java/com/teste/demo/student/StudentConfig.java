package com.teste.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student maria = new Student(
					"Maria Macedo",
					"mariamacedo2xx@gamil.com",
					LocalDate.of(2000, Month.JANUARY, 25)
					);
			
			Student alex = new Student(
					"alex Macedo",
					"alex2123@gamil.com",
					LocalDate.of(1995, Month.DECEMBER, 14)
					);
			
			repository.saveAll(List.of(maria, alex));
		};
	}
}
