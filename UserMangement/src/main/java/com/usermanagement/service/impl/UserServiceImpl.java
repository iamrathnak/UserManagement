package com.usermanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanagement.domain.User;
import com.usermanagement.exceptions.ServiceException;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.service.UserService;
import com.usermanagement.utils.CommonValidations;

/**
 * 
 * @author rathanakumark
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void CreateUser(User user) throws ServiceException {
		if (CommonValidations.validateEmail(user.getEmail()) && CommonValidations.validateEmail(user.getPassword())) {
			userRepository.save(user);

		} else {
			throw new ServiceException("ERR001", "Email or Password is Invalid");

		}

	}

	@Override
	public List<User> getAllUsers() {
		List<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(userOut -> user.add(userOut));
		return user;
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findOne(id);
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.delete(id);

	}

}
