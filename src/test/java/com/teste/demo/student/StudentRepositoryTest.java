package com.teste.demo.student;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.demo.student.StudentRepository;
import com.teste.demo.student.Student;

@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository underTest;
	
	@Test
	void itShouldIfSelectEmailExists() {
		
		String email = "mariamacedo2xx@gmail.com";
		//given 
		Student student = new Student(
					"maria",
					email,
					LocalDate.of(2000, Month.JANUARY, 25)
				);
		
    	underTest.save(student);
		
		//when
		boolean exists = underTest.selectExistsEmail(email);
		
		//then
		assertEquals(exists, true);
	}
	
	
	@Test
	void itShouldIfSelectEmailDoesNotExists() {
		String email = "mariamacedoasssasasaa2xx@gmail.com";
		
		//given 
		Student student = new Student(
					"maria",
					email,
					LocalDate.of(2000, Month.JANUARY, 25)
				);
		//when
		boolean exists = underTest.selectExistsEmail(email);
		
		//then
		assertEquals(exists, false);
	}
}
