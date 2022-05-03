package in.dhananjaygore.expensetrackerapi.service;

import in.dhananjaygore.expensetrackerapi.entity.User;
import in.dhananjaygore.expensetrackerapi.entity.UserModel;

public interface UserService {

	User createUser(UserModel user);
	
	User readUser();
	
	User updateUser(UserModel user);
	
	void deleteUser();
	
	User getLoggedInUser();
}
