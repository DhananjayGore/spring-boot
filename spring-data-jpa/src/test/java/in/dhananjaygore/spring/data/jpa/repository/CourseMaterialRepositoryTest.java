package in.dhananjaygore.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import in.dhananjaygore.spring.data.jpa.entity.Course;
import in.dhananjaygore.spring.data.jpa.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

	
	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		
		Course course = Course.builder()
				.title("head first Java")
				.credit(6)
				.build();
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
		.url("www.java.com")
		.course(course)
		.build();
		
		repository.save(courseMaterial);
	}

	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseMaterials = repository.findAll();
		System.out.println("courseMaterials =====> "+courseMaterials);
	}
}
