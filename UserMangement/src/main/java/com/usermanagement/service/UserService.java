package com.usermanagement.service;

import java.util.List;

import com.usermanagement.domain.User;
import com.usermanagement.exceptions.ServiceException;
/**
 * 
 * @author rathanakumark
 *
 */
public interface UserService {

	void CreateUser(User user) throws ServiceException;

	List<User> getAllUsers();

	User getUserById(int id);

	void deleteUserById(int id);

}
