package in.dhananjaygore.spring.data.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import in.dhananjaygore.spring.data.jpa.entity.Guardian;
import in.dhananjaygore.spring.data.jpa.entity.Student;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent() {
		Student student = Student.builder()
				.emailId("dvg29@gmail.com")
				.firstName("Dhananjay")
				.lastName("Gore")
				//.guardian("XYZ")
				//.guardianEmail("test@gmail.com")
				//.guardianMobile("9999999999")
				.build();
		studentRepository.save(student);
	}
	
	
	@Test
	public void saveStudentWithGuardian() {
		
		Guardian guardian = Guardian.builder()
				.name("dd 1")
				.email("guardian2@gmail.com")
				.mobile("99999999")
				.build();
		
		Student student = Student.builder()
				.emailId("abc112@gmail.com")
				.firstName("dhananjay")
				.lastName("gore")
				.guardian(guardian)
				.build();
		studentRepository.save(student);
	}
	
	@Test
	public void printAllStudent() {
		
		List<Student> studentList = studentRepository.findAll();
	}
	
	@Test
	public void printStudentByFirstName() {
		//List<Student> students =  studentRepository.findByFirstName("Dhananjay");
		List<Student> students =  studentRepository.findByFirstNameContaining("Dhan");
		System.out.println(students);
	}
	
	@Test
	public void printStudentBasedOnGuardianName() {
		List<Student> students = studentRepository.findByGuardianName("guardina 1");
		System.out.println("List Below ================================");
		System.out.println("Student -----> "+students);
	}
	
	@Test
	public void printStudentByEmailAddress() {
	
		Student student = studentRepository.getStudentByEmailAddress("Dvg1997@gmail.com");
		System.out.println("student -----> "+ student);
	}
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String firstName = studentRepository.getStudentFirstNameByEmailAddress("Dvg1997@gmail.com");
		System.out.println("Student first name ----> "+firstName);
	}
	
	@Test
	public void printGetStudnetByEmailAddressNative() {
		Student  student = studentRepository.getStudentByEmailAddressNative("Dvg1997@gmail.com");
		System.out.println("Student  ----> "+student);
	}
	
	@Test
	public void printGetStudnetByEmailAddressNativeNamedParam() {
		Student  student = studentRepository.getStudentByEmailAddressNativeNamedParam("Dvg1997@gmail.com");
		System.out.println("Student  ----> "+student);
	}
	
	@Test
	public void updateStudentFirstNameByEmailAddress() {
		int result = studentRepository.updateStudentNameByEmailId("dheeraj", "Dvg1997@gmail.com");
		System.out.println("Student =====> "+result);
	}
	
}
