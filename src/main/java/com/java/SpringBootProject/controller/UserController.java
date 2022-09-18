package com.java.SpringBootProject.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.SpringBootProject.business.abstracts.UserService;
import com.java.SpringBootProject.core.entities.User;
import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.ErrorDataResult;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
 @RequestMapping("/users")
public class UserController {
	
			private UserService userService;
			
			@Autowired
			public UserController(UserService userService) {
				super();
				this.userService = userService;
			}

			@PostMapping("/addUser")
			public ResponseEntity<?> add(@Valid @RequestBody User user) {
			return ResponseEntity.ok( this.userService.add(user));
			}
		 
			 @GetMapping("/findByEmail")
			public DataResult<User> findByEmail(@RequestParam String email) {
				return this.userService.findByEmail(email);
			
			}
			 
			 @ExceptionHandler(MethodArgumentNotValidException.class)
			 @ResponseStatus(HttpStatus.BAD_REQUEST)
			 public ErrorDataResult<Object> handleValidationException
			 (MethodArgumentNotValidException exceptions){
			Map<String , String> validationErrors = new HashMap<String, String>();
			for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
					 validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
				 }
				 ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları...");
				 return errors;
			 }
			 
			 
			 
			 
			
			

}
