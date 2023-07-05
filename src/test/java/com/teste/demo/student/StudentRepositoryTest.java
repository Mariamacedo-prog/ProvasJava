package com.teste.demo.student;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.assertArg;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentRepositoryTest {

	@Autowired
	private StudentRepository underTest;
	
	@Test
	void itShouldIfSelectExistsEmail() {
		
		//given
		String email = "mariamacedo2xzasasx@gmail.com";
		Student student = new Student(
				"maria",
				email,
				LocalDate.of(2000, Month.JANUARY, 25)
				);
		
		underTest.save(student);
		
		//when
		boolean exists = underTest.selectExistsEmail(email);
		
		//then
		assertSame(exists,true);
	}
}
