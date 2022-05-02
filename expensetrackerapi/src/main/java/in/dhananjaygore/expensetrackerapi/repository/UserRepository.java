package in.dhananjaygore.expensetrackerapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.dhananjaygore.expensetrackerapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Boolean existsByEmail(String email);
	
}
