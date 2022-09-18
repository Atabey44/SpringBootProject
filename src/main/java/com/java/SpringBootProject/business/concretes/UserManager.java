package com.java.SpringBootProject.business.concretes;

import org.springframework.stereotype.Service;

import com.java.SpringBootProject.business.abstracts.UserService;
import com.java.SpringBootProject.core.entities.User;
import com.java.SpringBootProject.core.repository.UserRepository;
import com.java.SpringBootProject.core.utilities.results.DataResult;
import com.java.SpringBootProject.core.utilities.results.Result;
import com.java.SpringBootProject.core.utilities.results.SuccessDataResult;
import com.java.SpringBootProject.core.utilities.results.SuccessResult;

@Service
public class UserManager  implements UserService{

				private UserRepository userRepository;
	  
				public UserManager(UserRepository userRepository) {
					super();
					this.userRepository = userRepository;
				}

				@Override
				public Result add(User user) {
					this.userRepository.save(user);
					return new SuccessResult("Kullanıcı Eklendi...");
				}
			
				@Override
				public DataResult<User> findByEmail(String email) {
					return new SuccessDataResult<User>
					(this.userRepository.findByEmail(email), "Kullanıcı Bulundu...");
	}

}
