package in.dhananjaygore.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import in.dhananjaygore.spring.data.jpa.entity.Course;
import in.dhananjaygore.spring.data.jpa.entity.Student;
import in.dhananjaygore.spring.data.jpa.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		
		List<Course> course = courseRepository.findAll();
		System.out.println("Courses " + course);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("priyanka")
				.lastName("Singh")
				.build();
		
		Course course = Course.builder()
				.title("java")
				.credit(7)
				.teacher(teacher)
				.build();
		courseRepository.save(course);
	}
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords)
				.getContent();
		
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords)
				.getTotalElements();
		
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords)
				.getTotalPages();
		
		System.out.println("totalPages  "+ totalPages);
		System.out.println("totalElements "+ totalElements);
		System.out.println("courses ======> "+courses);
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 3,Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 3,Sort.by("credit").descending());
		
		List<Course> courses  = courseRepository.findAll(sortByTitle).getContent();
	
		System.out.println("courses =====> "+courses);
	}
	
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		
		Page<Course> page  = courseRepository.findByTitleContaining("J",firstPageTenRecords );
	
		List<Course> courses = page.getContent();
		System.out.println("courses =====> "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		
		Teacher teacher = Teacher.builder()
				.firstName("John")
				.lastName("michale")
				.build();
		
		Student student = Student.builder()
				.firstName("rahul")
				.lastName("gupta")
				.emailId("rahul.gupta11@gmail.com")
				.build();
		
		Course course = Course.builder()
				.title("Spring boot")
				.credit(9)
				.teacher(teacher)
				.build();
		
		course.addStudents(student);
		courseRepository.save(course);
	}
	
	
}
