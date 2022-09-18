package com.java.SpringBootProject.business.abstracts;

import com.java.SpringBootProject.core.entities.User;
import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.Result;

public interface UserService {
	
				Result add (User user);
				DataResult<User> findByEmail(String email);
	

}
