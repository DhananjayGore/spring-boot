package in.dhananjaygore.expensetrackerapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.dhananjaygore.expensetrackerapi.entity.User;
import in.dhananjaygore.expensetrackerapi.entity.UserModel;
import in.dhananjaygore.expensetrackerapi.exceptions.ItemAlreadyExistException;
import in.dhananjaygore.expensetrackerapi.exceptions.ResourceNotFoundException;
import in.dhananjaygore.expensetrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(UserModel user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistException("User is already register with email :"+user.getEmail());
		}
		User newUSer = new User();
		BeanUtils.copyProperties(user, newUSer);
		newUSer.setPassword(bcryptEncoder.encode(newUSer.getPassword()));
		return userRepository.save(newUSer);
	}

	@Override
	public User readUser() {
		Long userId = getLoggedInUser().getId();
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found for the id: "+userId));
	}

	@Override
	public User updateUser(UserModel user) {
		
		User existingUser = readUser();
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
		existingUser.setAge(user.getName() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}

	@Override
	public void deleteUser() {
		User existingUser = readUser();
		userRepository.delete(existingUser);
	}

	@Override
	public User getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("user with"+email+"not found"));
	}
	
	
}






