package in.dhananjaygore.expensetrackerapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.dhananjaygore.expensetrackerapi.entity.User;
import in.dhananjaygore.expensetrackerapi.entity.UserModel;
import in.dhananjaygore.expensetrackerapi.service.UserService;

@RestController
public class AuthController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<String>("User is logged in", HttpStatus.OK);
	}
	

	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModel user)
	{
		User respUser= userService.createUser(user);
		return new ResponseEntity<>(respUser, HttpStatus.CREATED);
	}
	
}
