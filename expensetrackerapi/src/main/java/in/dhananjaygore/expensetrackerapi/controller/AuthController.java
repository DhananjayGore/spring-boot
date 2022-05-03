package in.dhananjaygore.expensetrackerapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.dhananjaygore.expensetrackerapi.entity.AuthModel;
import in.dhananjaygore.expensetrackerapi.entity.JwtResponse;
import in.dhananjaygore.expensetrackerapi.entity.User;
import in.dhananjaygore.expensetrackerapi.entity.UserModel;
import in.dhananjaygore.expensetrackerapi.security.CustomUserDetailsService;
import in.dhananjaygore.expensetrackerapi.service.UserService;
import in.dhananjaygore.expensetrackerapi.util.JwtTokenUtil;

@RestController
public class AuthController {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody AuthModel authModel) throws Exception{
		authenticate(authModel.getEmail(), authModel.getPassword());
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authModel.getEmail());
		
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);
		
		return new ResponseEntity<JwtResponse>(new JwtResponse(jwtToken) ,HttpStatus.OK);
	}
	

	private void authenticate(String email, String password) throws Exception {
	
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		    
		}
		catch (DisabledException e) {
			throw new Exception("User Disabled");
		}
		catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}
		
	}


	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user)
	{
		User respUser= userService.createUser(user);
		return new ResponseEntity<>(respUser, HttpStatus.CREATED);
	}
	
}
