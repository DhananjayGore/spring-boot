package in.dhananjaygore.spring.data.jpa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.dhananjaygore.spring.data.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstName(String fname);

	public List<Student> findByFirstNameContaining(String name);

	List<Student> findByLastNameNotNull();

	List<Student> findByGuardianName(String name);

	Student findByFirstNameAndLastName(String firstName, String lastName);

	// JPQL query are based on class that we created not on db table
	@Query("select s from Student s where s.emailId = ?1")
	Student getStudentByEmailAddress(String email);

	// JPQL query to get firstname by emailId of Student
	@Query("select s.firstName from Student s where s.emailId = ?1")
	String getStudentFirstNameByEmailAddress(String email);
	
	
	//Native Query
	@Query(
			value = "SELECT * from tbl_student s where s.email_address = ?1",
			nativeQuery = true
			)
	Student getStudentByEmailAddressNative(String email);
	
	
	//Native Named Query
	@Query(
			value = "SELECT * from tbl_student s where s.email_address = :emailId",
			nativeQuery = true
			)
	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
	

	@Modifying
	@Transactional
	@Query(
			value = "update tbl_student set first_name = :fname where email_address = :email",
			nativeQuery = true
			)
	int updateStudentNameByEmailId(@Param("fname") String firstName,@Param("email") String emailId);
	
	
}
