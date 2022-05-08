package in.dhananjaygore.spring.data.jpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.dhananjaygore.spring.data.jpa.entity.Course;
import in.dhananjaygore.spring.data.jpa.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {

	
	@Autowired 
	private TeacherRepository repository;
	
	@Test
	public void saveTeacher() {
		
		Course course1 = Course.builder()
				.title("DSA course")
				.credit(5)
				.build();
		Course course2 = Course.builder()
				.title("java course")
				.credit(7)
				.build();
		
		Teacher teacher = Teacher.builder()
				.firstName("Dhananjay")
				.lastName("Gore")
				//.courses(List.of(course1, course2))
				.build();
		
		repository.save(teacher);
	}
}
