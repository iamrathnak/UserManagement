package com.usermanagement.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.domain.User;
import com.usermanagement.domain.UserLogin;
import com.usermanagement.exceptions.ServiceException;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.LoginService;
import com.usermanagement.utils.CommonValidations;

/**
 * 
 * @author rathanakumark
 *
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User authenticateUser(UserLogin userLogin) throws ServiceException {
		User user=null;
		
		if(CommonValidations.validateEmail(userLogin.getEmail())&&CommonValidations.validateEmail(userLogin.getPassword())){;
		
		 user = userRepository.findUserCredentials(userLogin.getEmail(), userLogin.getPassword());
		if (user != null) {
			userRepository.updateLastLogin(new Date(), userLogin.getEmail(), userLogin.getPassword());
		}
		}else {
			throw new ServiceException("ERR001","Email or Password is Invalid");
			
		}
		return user;
	}

}
