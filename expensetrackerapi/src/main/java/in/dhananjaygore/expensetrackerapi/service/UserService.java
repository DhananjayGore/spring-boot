package in.dhananjaygore.expensetrackerapi.service;

import in.dhananjaygore.expensetrackerapi.entity.User;
import in.dhananjaygore.expensetrackerapi.entity.UserModel;

public interface UserService {

	User createUser(UserModel user);
	
	User readUser(Long id);
	
	User updateUser(UserModel user, Long id);
	
	void deleteUser(Long id);
}
